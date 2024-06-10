package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.AnLa.FILE.Log;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALParam;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/MyAcc")
public class MyAcc {
	@Autowired
	SinhvienDAO sinhvienDAO;
	
	@GetMapping
	public String MyAccGET() {
		return "User/MyAcc";
	}
	
	@PostMapping
	public String MyAccPOST(Sinhvien sv, @RequestParam("picAvatar") MultipartFile avatar) {
		// Xử lí dữ liệu
		Sinhvien currSV = (Sinhvien) ALSession.getSession("userSV");	// Lấy sinhvien hiện tại
		String idsv = currSV.getUsername();								// Lấy idsv hiện tại
		
		// Thông báo qua Log
		Log.add("MyAccPOST - Try to update account with username: " + currSV.getUsername());
		
		try { // Lưu ảnh đại diện của sinhvien
			String  abPath = ALParam.saveFile(avatar, "/Image/UsersAvatar/", idsv+".png").getAbsolutePath(),
					imPath = abPath.substring(abPath.lastIndexOf("\\Image\\UsersAvatar"));
			currSV.setAvatar(imPath);
		} catch (Exception e) {
			Log.add("SignUpPOST - Exception when try to save file from client !!!\n\t\tError code: " + e.toString());
		}
		
		// Lưu dữ liệu vào csdl
		currSV.setTen(sv.getTen());
		sinhvienDAO.save(currSV);
		
		// Add seesion scope
		ALSession.setSession("userSV", sinhvienDAO.findById(idsv).get());
		
		// Thông báo qua Log
		Log.add("MyAccPOST - Update account successfully !");
		return "redirect:/MyAcc";
	}
	
}