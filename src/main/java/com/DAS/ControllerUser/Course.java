package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AnLa.FILE.Log;
import com.DAS.DAO.DanhgiaDAO;
import com.DAS.DAO.KhoahocDAO;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.DAO.TainguyenDAO;
import com.DAS.Entity.Danhgia;
import com.DAS.Entity.DanhgiaId;
import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/Course")
public class Course {
	@Autowired
	KhoahocDAO khoahocDAO;
	@Autowired
	SinhvienDAO sinhvienDAO;
	@Autowired
	DanhgiaDAO danhgiaDAO;
	@Autowired
	TainguyenDAO tainguyenDAO;
	
	
	
	@GetMapping("/{idkh}")
	public String CourseGET(@PathVariable("idkh") String idkh, Model model) {
		// Xử lí dữ liệu
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();// Lấy idsv hiện tại
		Khoahoc course = khoahocDAO.findById(idkh).get();						// Lấy khoá học theo idkh
		Danhgia rating = danhgiaDAO.findById(new DanhgiaId(idsv, idkh)).orElse(new Danhgia());	// Lấy đánh giá của sinhvien theo idsv và idkh

		// Set dữ liệu qua view
		model.addAttribute("Course", course);
		model.addAttribute("Rating", rating);
		
		// Thông báo qua Log
		Log.add("CourseGET - View Course " + idkh + " by " + idsv);
		return "User/Course";
	}
	
	@GetMapping("/{idkh}/Join")
	public String CourseJOIN(@PathVariable("idkh") String idkh) {
		// Xử lí dữ liệu
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();// Lấy idsv hiện tại
		boolean ixExists = sinhvienDAO.isExistsSV_KH(idsv, idkh);				// Kiểm tra sinh viên đã tồn tại trong khoá học chưa
		if(!ixExists) {	// Nếu chưa thì thêm vào csdl
			Sinhvien sv = sinhvienDAO.findById(idsv).get();	
			Khoahoc kh  = khoahocDAO.findById(idkh).get();
			sv.getKhoahocs().add(kh);
//			kh.getSinhviens().add(sv);
			sinhvienDAO.save(sv);
//			khoahocDAO.save(kh);
			
			// Thông báo qua Log
			  Log.add("CourseJOIN - Username " + idsv + " join course " + idkh);
		}else Log.add("CourseJOIN - Username " + idsv + " view course " + idkh);
		
		return "redirect:/Course/" + idkh + "/Material";
	}
	
	@GetMapping("/{idkh}/Material")
	public String MaterialGET(@PathVariable("idkh") String idkh, @RequestParam("idtn") Optional<Integer> idtn, Model model) {
		// Xử lí dữ liệu
		Khoahoc khoahoc = khoahocDAO.findById(idkh).get();						// Lấy khoá học theo idkh
		Integer currTN = idtn.orElse(khoahoc.getTainguyens().get(0).getIdtn());	// Lấy idtn của trang hiện tại, nếu không có gán idtn đầu tiên

		// Set dữ liệu qua view
		model.addAttribute("Khoahoc", khoahoc);
		model.addAttribute("Tainguyen", tainguyenDAO.findById(currTN).get());
		
		// Thông báo qua Log
		Log.add("MaterialGET - View material " + currTN + " in course " + idkh);
		return "User/CourseMaterial";
	}
	
	@PostMapping("/{idkh}")
	public String CoursePOST(@PathVariable("idkh") String idkh, @RequestParam("Sao") Optional<Double> sao, @RequestParam("Descrip") Optional<String> des,  Model model) {
		// Xử lí dữ liệu
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();// Lấy idsv hiện tại
		Sinhvien sv = sinhvienDAO.findById(idsv).get();							// Lấy sinhvien theo idsv
		DanhgiaId id = new DanhgiaId(idsv, idkh);								// Lấy ID đánh giá theo idsv, idkh
		Danhgia oldDG = danhgiaDAO.findById(id).orElse(new Danhgia());			// Lấy đánh giá cũ trong csdl
		Danhgia newDG = new Danhgia(id, new Khoahoc(idkh), sv,					// Ghi đè lại đánh giá mới
									des.orElse(oldDG.getBinhluan()), 			// Ghi đè bình luận mới, nếu không có thì lấy bình luận cũ
									sao.orElse(oldDG.getSao()));				// Ghi đè số sao mới, nếu không có thì lấy số sao cũ
		danhgiaDAO.save(newDG);													// Lưu thay đổi vào csdl
		
		// Thông báo qua Log
		if(sao.isPresent()) Log.add("CoursePOST - Username " + idsv + " voting on course " + idkh + ": " + sao.get());
		if(des.isPresent()) Log.add("CoursePOST - Username " + idsv + " rating on course " + idkh + ": " + des.get());
		return "User/Course";
	}
}