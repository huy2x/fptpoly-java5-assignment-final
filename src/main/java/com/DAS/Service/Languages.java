package com.DAS.Service;
//Make By Bình An || AnLaVN || KatoVN

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class Languages implements WebMvcConfigurer {
	
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("classpath:/languages/Certificate",
						"classpath:/languages/Course",
						"classpath:/languages/Footer",
						"classpath:/languages/GetBackground",
						"classpath:/languages/Header",
						"classpath:/languages/Home",
						"classpath:/languages/MyAcc",
						"classpath:/languages/ResetPass",
						"classpath:/languages/Service",
						"classpath:/languages/SignIn",
						"classpath:/languages/SignUp",
						"classpath:/languages/Title");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Bean("localeResolver")
	public LocaleResolver getLocalResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("vi"));
		resolver.setCookiePath("/");
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor li = new LocaleChangeInterceptor();
		li.setParamName("lang");
		registry.addInterceptor(li).addPathPatterns("/**");
	}

}