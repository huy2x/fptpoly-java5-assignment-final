package com.DAS.Service;
//Make By Bình An || AnLaVN || KatoVN

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestFilter implements WebMvcConfigurer{
	@Autowired
	Authentication auth;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth)
				.addPathPatterns("/**")
				.excludePathPatterns("/", "/SERVICE", "/SignIn", "/SignUp", "/SignOut", "/ResetPass", "/resources/**", "/Image/**");
	}	
}