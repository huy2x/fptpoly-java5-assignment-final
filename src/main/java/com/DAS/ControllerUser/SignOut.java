package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AnLa.FILE.Log;
import com.DAS.Tools.ALCookie;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/SignOut")
public class SignOut {
	
	@RequestMapping
	public String SignOutREQ() {
		// Xử lí dữ liệu
		ALSession.removeSession("userSV");		// Xoá dữ liệu session userSV
		ALSession.removeSession("userAD");		// Xoá dữ liệu session userAD
		if(ALCookie.get("userSignInCookie") != null) {
			ALCookie.remove("userSignInCookie");// Xoá dữ liệu cookie
		}
		
		// Thông báo qua Log
		Log.add("SignOutREQ - Sign Out successfully.");
		return "redirect:/";
	}
}