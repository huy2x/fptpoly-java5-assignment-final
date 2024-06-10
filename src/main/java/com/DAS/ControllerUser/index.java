package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class index {
	
	@GetMapping
	public String indexGET(Model model) {
		model.addAttribute("WebView", "HOME");
		return "User/index";
	}
	
	@GetMapping("/SERVICE")
	public String SERVICEGET(Model model) {
		model.addAttribute("WebView", "SERVICE");
		return "User/index";
	}

}