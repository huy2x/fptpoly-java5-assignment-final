package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAS.DAO.KhoahocDAO;
import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Phanloai;

@Controller
@RequestMapping("/Courses")
public class Courses {
	@Autowired
	KhoahocDAO khoahocDAO;
	
	@GetMapping
	public String CoursesGET(@RequestParam("page") Optional<Integer> pPage, @RequestParam("phanloai") Optional<String> pPhanloai, @RequestParam("search") Optional<String> pSearch, Model model) {
		// Xử lí dữ liệu
		int currentPage = pPage.orElse(1);		// Tạo biến current page chứa chỉ số trang hiện tại, mặc định là 1
		boolean isNType = pPhanloai.isEmpty(),	// Tạo biến is NOT type nếu ko chứa id phân loại cần tìm kiếm
				isNFind = pSearch.isEmpty();	// Tạo biến is NOT find nếu ko chứa chuỗi cần tìm kiếm
		String  cType = pPhanloai.orElse(null),	// Tạo biến current type chứa id phân loại cần tìm kiếm
				cFind = pSearch.orElse(null);	// Tạo biến current find chứa chuỗi cần tìm kiếm
		
		// Tạo page
		Pageable pageable = PageRequest.of(currentPage - 1, 6);
		Page<Khoahoc> coursesPage = null;
		
		// Gán page theo điều kiện tìm kiếm
		if(isNType && isNFind)	coursesPage = khoahocDAO.findAll(pageable);								// KO tìm id phân loại, KO tìm search, tìm tất cả
		else if(isNFind)		coursesPage = khoahocDAO.findByPhanloai(new Phanloai(cType), pageable);	// Tìm id phân loại, KO tìm search
		else if(cFind.equals("getBackground()")) return "User/Background";									// Easter Egg Background
		else 					coursesPage = khoahocDAO.findByTenkhoahocLike("%"+cFind+"%", pageable);	// KO tìm id phân loại, tìm search
		
		// Set dữ liệu qua view
		model.addAttribute("CoursesPage", coursesPage);
		model.addAttribute("CurrentPage", currentPage);
		return "User/Courses";
	}
	
}