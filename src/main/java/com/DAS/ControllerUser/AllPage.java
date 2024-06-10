package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.DAS.DAO.PhanloaiDAO;
import com.DAS.Entity.Phanloai;
import com.DAS.Tools.ALSession;

@ControllerAdvice
public class AllPage {
	@Autowired
	PhanloaiDAO phanloaiDAO;
	
	@ModelAttribute("listPhanloai")
	public List<Phanloai> getListPhanloai(){
		return phanloaiDAO.findAll();
	}
	
	@ModelAttribute("isUserSV")
	public boolean isUserSV() {
		return ALSession.getSession("userSV") != null;
	}
	
	@ModelAttribute("isUserAD")
	public boolean isUserAD() {
		return ALSession.getSession("userAD") != null;
	}
}