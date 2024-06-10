package com.DAS.ControllerThongke;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAS.DAO.KhoahocDAO;
import com.DAS.Entity.Khoahoc;

@Controller
@RequestMapping("/admin/ThongKe")
public class Thongke {
	@Autowired
	KhoahocDAO khoahocDAO;
	
	@GetMapping
	public String ThongkeGET(@RequestParam("page") Optional<Integer> pPage, Model model) {
		// Xử lí dữ liệu
		int currentPage = pPage.orElse(1);		// Tạo biến current page chứa chỉ số trang hiện tại, mặc định là 1
		
		// Tạo page
		Pageable pageable = PageRequest.of(currentPage - 1, 6);
		Page<Khoahoc> coursesPage = khoahocDAO.findAll(pageable);
		
		// Set dữ liệu qua view
		model.addAttribute("CoursesPage", coursesPage);
		model.addAttribute("CurrentPage", currentPage);
		model.addAttribute("view","Module/Thongke.jsp");
		return "/Admin/indexAdmin";
	}
	
	@ModelAttribute("sizeCourses")
	public int getSizeCourses(){
		return khoahocDAO.findAll().size();
	}
}