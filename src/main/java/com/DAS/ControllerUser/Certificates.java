package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AnLa.FILE.Log;
import com.DAS.DAO.KhoahocDAO;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Diem;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/Certificates")
public class Certificates {
	@Autowired
	KhoahocDAO khoahocDAO;
	@Autowired
	SinhvienDAO sinhvienDAO;

	@GetMapping
	public String CertificatesGET(@RequestParam("page") Optional<Integer> pPage, Model model) {
		// Xử lí dữ liệu
		int currentPage = pPage.orElse(1);		// Lấy chỉ số trang hiện tại, nếu không có gán là 1
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();	// Lấy idsv hiện tại
		List<Diem> listDiem = sinhvienDAO.findById(idsv).get().getDiems();			// Lấy list điểm của sinhvien theo idsv
		
		// Tạo page
		Pageable pageable = PageRequest.of(currentPage - 1, 6);
		Page<Diem> CertifiPage = new PageImpl<Diem>(listDiem, pageable, listDiem.size());	
		
		// Set dữ liệu qua view
		model.addAttribute("CertifiPage", CertifiPage);
		model.addAttribute("CurrentPage", currentPage);
		
		// Thông báo qua Log
		Log.add("CertificatesGET - Get " + CertifiPage.getTotalElements() + " certificates of " + idsv);
		return "User/Certificates";
	}
}