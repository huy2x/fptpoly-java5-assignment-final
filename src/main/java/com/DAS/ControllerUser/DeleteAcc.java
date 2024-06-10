package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AnLa.FILE.Log;
import com.AnLa.HASH.SHA256;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Sinhvien;

@Controller
@RequestMapping("/DeleteAcc")
public class DeleteAcc {
	@Autowired
	SinhvienDAO sinhvienDAO;
	
	@PostMapping
	public String DeleteAccPOST(Sinhvien sv) {
		// Xử lí dữ liệu
		String  idsv = SHA256.Encrypt(sv.getUsername()),
				pass = SHA256.Encrypt(sv.getMatkhau());
		
		// Nếu idsv và pass tồn tại trong csdl
		if(sinhvienDAO.existsByUsernameAndMatkhau(idsv, pass)) {
			new File("src\\main\\webapp\\Image\\UsersAvatar\\"+idsv+".png").delete();	// Xoá avatar khỏi server
			sinhvienDAO.deleteById(idsv);												// Xoá thông tin khỏi csdl
			
			// Thông báo qua Log
			  Log.add("DeleteAccPOST - Delete all information of username " + idsv);
		}else Log.add("DeleteAccPOST - Incorrect username or password of: " + idsv);
		
		return "redirect:/SignOut";
	}
}