package com.DAS.Service;
//Make By Bình An || AnLaVN || KatoVN

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.AnLa.FILE.Log;
import com.AnLa.HASH.AES;
import com.DAS.DAO.AdminDAO;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Tools.ALCookie;
import com.DAS.Tools.ALSession;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Authentication implements HandlerInterceptor{
	@Autowired
	SinhvienDAO sinhvienDAO;
	@Autowired
	AdminDAO adminDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Xử lí dữ liệu
		String  cookie = ALCookie.get("userSignInCookie");
		
		// Nếu có seesion thì cho đi tiếp
		if(request.getSession().getAttribute("userSV") != null || request.getSession().getAttribute("userAD") != null)  return true;
		else if(cookie != null) {												// Ngược lại kiểm tra cookie
			try {
				int iX = cookie.indexOf("~");									// Lấy vị trí dấu phân cách
				String	hashUsername = cookie.substring(0, iX),					// Lấy hash username trong cookie và hash password
						hashPassword = AES.Decrypt(cookie.substring(iX + 1), "DAS" + hashUsername);
				
				if(sinhvienDAO.existsByUsernameAndMatkhau(hashUsername, hashPassword)) {	// Kiểm tra admin có tồn tại trong csdl hay không
					ALSession.setSession("userAD",adminDAO.findById(hashUsername).get());	// Nếu có gán sinhvien vào session và cho đi tiếp
					
					// Thông báo qua Log
					Log.add("Authentication - Auto SignIn with cookies for admin " + hashUsername);
					return true;
				}
				else if(sinhvienDAO.existsByUsernameAndMatkhau(hashUsername, hashPassword)){// Kiểm tra sinhvien có tồn tại trong csdl hay không
					ALSession.setSession("userSV",sinhvienDAO.findById(hashUsername).get());// Nếu có gán sinhvien vào session và cho đi tiếp
					
					// Thông báo qua Log
					Log.add("Authentication - Auto SignIn with cookies for username " + hashUsername);
					return true;
				}
			}catch (Exception e) {Log.add("Authentication - Can not get cookie information of client !!!");}
		}
		
		response.sendRedirect("/SignIn");		// Không thoả bất kì trường hợp nào thì chuyển hướng về trang đăng nhập
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}