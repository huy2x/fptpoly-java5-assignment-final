package com.DAS.ControllerAdmin;

//Make by TIẾN SỸ|| TTS
import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.DAS.DAO.KhoahocDAO;
import com.DAS.DAO.PhanloaiDAO;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Phanloai;
import com.DAS.Tools.ALParam;
import com.DAS.Tools.UpFileCloud;

@Controller
public class ADKhoaHocController {
	@Autowired
	KhoahocDAO khoahocDAO;

	@Autowired
	PhanloaiDAO phanloaiDAO;

	@Autowired
	SinhvienDAO sinhvienDAO;

	boolean ckDeleteKH = false;

	@RequestMapping("/admin/khoahoc")
	public String khoaHoc(Model model, @RequestParam("pageNo") Optional<Integer> pageNo,
			@RequestParam("keywords") Optional<String> keywords, @RequestParam("idPL") Optional<String> idPL) {
	
		int indexPage = pageNo.orElse(0);
		Pageable pageable = PageRequest.of(pageNo.orElse(0), 9);
		Page<Khoahoc> listKhoaHoc = khoahocDAO.findAllByNameLikeAndPL(keywords.orElse(""), idPL.orElse(""), pageable);
		model.addAttribute("listKhoaHoc", listKhoaHoc);
		model.addAttribute("indexPage", indexPage);
		model.addAttribute("view", "Module/ADKhoaHoc.jsp");
		// check khóa học delete thành công hiển thị toast
		
		if (ckDeleteKH) {
			model.addAttribute("message", true);
			ckDeleteKH = false;
		}
		return "/Admin/indexAdmin";
	}

	// Tìm kiếm kh theo id và fill lên form ct khóa học
	@GetMapping("/admin/khoahoc/{idkh}")

	public String CTkhoaHoc(Model model, @PathVariable("idkh") String idkh) {

		model.addAttribute("message", false);
		Khoahoc khoahoc = khoahocDAO.findById(idkh).get();
		List<Khoahoc> listKhoaHoc = khoahocDAO.findAll();
		model.addAttribute("listKhoaHoc", listKhoaHoc);
		model.addAttribute("khoaHoc", khoahoc);
		model.addAttribute("view", "Module/ADCTKhoaHoc.jsp");

		return "/Admin/indexAdmin";
	}

	// Cập nhật thông tin khóa học
	@ResponseBody
	@PostMapping("/admin/update/{idkh}")
	public String UpdateKH(Model model, @PathVariable("idkh") String idkh, Khoahoc khoahoc,
			@RequestParam("fileAnh") MultipartFile fileUp) {
		System.out.println("okok");
		try {
			// tìm khóa học
			Khoahoc kh = khoahocDAO.findById(idkh).get();
			if (!fileUp.isEmpty()) {
				// lƯU Tạm FILE ẢNH VÀO MÁY CHỦ
				File file = ALParam.saveFile(fileUp);

				// gọi hàm upload lên cloudinary
				String pathCloudinary = UpFileCloud.upCloudBinaryByFile(file);

				// SAU KHI UP LÊN CLOUD XOG THÌ XÓA FILE ẢNH TRÊN MÁY CHỦ
				file.delete();

//				xóa ảnh củ trên cloud
				System.out.println("url kh" + kh.getAnhmota());
				UpFileCloud.removeCloudBinaryByUrl(kh.getAnhmota());

				// cập nhật lại ảnh mới
				kh.setAnhmota(pathCloudinary);

			}
			// set lại các trường cần update
			kh.setTenkhoahoc(khoahoc.getTenkhoahoc());
			kh.setMota(khoahoc.getMota());
			kh.setMotangan(khoahoc.getMotangan());
			kh.setPhanloai(khoahoc.getPhanloai());
			khoahocDAO.saveAndFlush(kh);

		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}

	// gọi form thêm khóa học
	@GetMapping("/admin/addKH")
	public String ThemkhoaHoc(Model model) {
		model.addAttribute("view", "Module/ADThemKhoaHoc.jsp");
		return "/Admin/indexAdmin";
	}

	// Thêm mới khóa học
	@ResponseBody
	@PostMapping("/admin/addKH")
	public String ThemkhoaHoc(Khoahoc khoahoc, @RequestParam("fileAnh") MultipartFile fileUp) {


		if(khoahocDAO.existsByIdkh(khoahoc.getIdkh())) return "ID khóa học đã tồn tại !";
		try {
			
			// lƯU Tạm FILE ẢNH VÀO MÁY CHỦ
			File file = ALParam.saveFile(fileUp);

			// gọi hàm upload lên cloudinary
			String pathCloudinary = UpFileCloud.upCloudBinaryByFile(file);

			// SAU KHI UP LÊN CLOUD XOG THÌ XÓA FILE ẢNH TRÊN MÁY CHỦ
			file.delete();

			khoahoc.setAnhmota(pathCloudinary);
			khoahocDAO.save(khoahoc);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "false";
	}

	// xóa khóa học
	@GetMapping("/admin/removeKH/{idkh}")
	public String xoaKhoaHoc(@PathVariable("idkh") String idkh) {
		try {
			// tìm ra khóa học
			Khoahoc kh = khoahocDAO.findById(idkh).get();

			// xóa ảnh trên cloudinary
			UpFileCloud.removeCloudBinaryByUrl(kh.getAnhmota());
			// xóa khóa học trên csdl
			khoahocDAO.delete(kh);
			ckDeleteKH = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/khoahoc";
	}

	// lấy phân loại để fill vào combobox Phân loại
	@ModelAttribute(name = "phanLoai")
	public List<Phanloai> getPhanLoai() {
		return phanloaiDAO.findAll();
	}
	
	@ModelAttribute(name = "listKhoaHoc")
	public Page<Khoahoc> getKhoaHoc() {
		Pageable pageable = PageRequest.of(0, 9);
		return  khoahocDAO.findAllByNameLikeAndPL("","",pageable);
		
	}

}
