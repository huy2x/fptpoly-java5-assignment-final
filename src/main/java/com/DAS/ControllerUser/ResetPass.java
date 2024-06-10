package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AnLa.FILE.Log;
import com.AnLa.HASH.SHA256;
import com.AnLa.NET.RandomORG;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALEmail;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/ResetPass")
public class ResetPass {
	@Autowired
	SinhvienDAO sinhvienDAO;
	
	private String OTP = "", email = "";
	
	@GetMapping
	public String ResetPassGET() {
		return "User/ResetPass";
	}
	
	@PostMapping
	public String ResetPassPOST(@RequestParam("txtOTP") String pOTP,@RequestParam("txtEmailRP") String pEmail, @RequestParam("txtCPassRP") String pPassword, Model model) {
		// Xử lí dữ liệu
		if(pEmail.equals(email) && pOTP.equals(OTP)) {		// Nếu email và mã OTP trùng khớp
			Sinhvien sv = sinhvienDAO.findByEmail(email);	// Lấy thông tin sinhvien theo email
			sv.setMatkhau(SHA256.Encrypt(pPassword));		// Lưu mật khẩu mới đã hash
			sinhvienDAO.save(sv);							// Lưu thông tin vào csdl
			ALSession.removeSession("userSV");				// Xoá dữ liệu session
			OTP = ""; email = "";							// Reset OTP và email
			
			// Thông báo qua Log
			Log.add("ResetPassPOST - Change password for " + sv.getUsername() + " successfully.");
			return "redirect:/SignIn";
			
		// Ngược lại thông báo qua Log	
		}else model.addAttribute("Toast", true);
		OTP = ""; email = "";								// Reset OTP và email
		return "User/ResetPass";
	}
	
	@PostMapping("/SendEmail")
	public String ResetPassOTP(@RequestParam("email") String pEmail) {
		OTP = ""; email = "";								// Reset OTP và email
		try {
			if(sinhvienDAO.existsByEmail(pEmail)) {			// Nếu địa chỉ email tồn tại trong csdl
				// Xử lí dữ liệu
				email = pEmail;								// Lưu địa chỉ email vào biến tạm
				OTP = RandomORG.getString(8, true, true, true);	// Lấy mã OTP gồm 8 kí tự chữ thường, hoa, số
				String  text = "Chúng tôi đã nhận được yêu cầu thay đổi mật khẩu của bạn.<br>"
								+ "Nếu bạn không gửi yêu cầu này, xin vui lòng bỏ qua email này.<br><br>"
								+ "Nếu bạn tiếp tục nhận được yêu cầu thay đổi mật khẩu, <br>"
								+ "điều này đồng nghĩa với việc có ai đó đang cố gắng xâm nhập vào tài khoản của bạn.",
						content = ALEmail.HTMLTemplate		// Nạp thông tin email
									.replaceFirst("USERNAME", ALEmail.getHTMLString(sinhvienDAO.findByEmail(email).getTen()))
									.replaceFirst("CONTENT", ALEmail.getHTMLString(text).replaceAll("&#60;&#98;&#114;&#62;", "<br>"))
									.replaceFirst("OTPCODE", OTP)
									.replaceFirst("WARNING", ALEmail.getHTMLString("Không chia sẻ mã này cho bất kì ai !"))
									.replaceFirst("THANK", ALEmail.getHTMLString("Trân trọng, đội ngũ DAS_Courses"));
				
				// Gửi email
				ALEmail.ZohoMail.setEmail("Yêu cầu thay đổi mật khẩu", content);	// Set thông tin email vào máy chủ SMTP
				ALEmail.ZohoMail.sendEmailTO(email);								// Gửi email đến địa chỉ của sinhvien
				
				// Thông báo qua Log
				Log.add("ResetPassOTP - Send OTP code for user email: " + email);
			}
		} catch (IOException | MessagingException e) {
			Log.add("ResetPassOTP - Error when try to send email to: " + email + "\n\tError code: " + e.toString());
		}
		
		return "redirect:/";
	}
}