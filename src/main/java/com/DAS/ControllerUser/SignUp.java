package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.AnLa.FILE.Log;
import com.AnLa.HASH.AES;
import com.AnLa.HASH.SHA256;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALCookie;
import com.DAS.Tools.ALParam;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/SignUp")
public class SignUp {
	@Autowired
	SinhvienDAO sinhvienDAO;
	
	@GetMapping
	public String SignUpGET() {
		return "User/SignUp";
	}
	
	@PostMapping
	public String SignUpPOST(Sinhvien sv, @RequestParam("picAvatar") MultipartFile avatar, Model model) {
		// Xử lí dữ liệu
		String  username = SHA256.Encrypt(sv.getUsername()),// Mã hoá username thành hash username
				password = SHA256.Encrypt(sv.getMatkhau());	// Mã hoá password thành hash password
		sv.setUsername(username);							// Lưu username đã mã hoá
		sv.setMatkhau(password);							// Lưu password đã mã hoá
		
		// Thông báo qua Log
		Log.add("SignUpPOST - Try to sign up with username: " + username);
		
		// Kiểm tra sinhvien có username và email trong csdl hay không
		boolean isExistsUsername = sinhvienDAO.existsByUsername(username),	// Tìm username có trong csdl hay không
				isExistsEmail = sinhvienDAO.existsByEmail(sv.getEmail());	// Tìm email có trong csdl hay không
		
		if(!isExistsUsername && !isExistsEmail) {	// Nếu chưa tồn tại thì lưu vào csdl
			
			try { // Lưu ảnh đại diện của sinhvien
				String  abPath = ALParam.saveFile(avatar, "/Image/UsersAvatar/", username+".png").getAbsolutePath(),
						imPath = abPath.substring(abPath.lastIndexOf("\\Image\\UsersAvatar"));
				sv.setAvatar(imPath);
			} catch (IllegalStateException | IOException e) {
				Log.add("SignUpPOST - Exception when try to save file from client !!!\n\t\tError code: " + e.toString());
			}

			// Lưu dữ liệu vào csdl và cookies
			sinhvienDAO.save(sv);					
			ALCookie.add("userSignInCookie", username + "~" + AES.Encrypt(password, "DAS" + username), 7*24);
			
			// Add session scope
			ALSession.setSession("userSV", sinhvienDAO.findById(username).get());
			
			// Thông báo qua Log
			Log.add("SignUpPOST - Sign up successfully !");
			return "redirect:/";
		}
		
		// Nược lại nếu trùng username hoặc email
		Log.add("SignUpPOST - Can not sign up !!!");// Thông báo qua Log
		model.addAttribute("Toast", true);			// Hiển thị thông báo lỗi
		return "User/SignUp";
	}

}