package com.DAS;
//Make by Bình An || AnLaVN || KatoVN

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AnLa.HASH.AES;
import com.AnLa.HASH.SHA256;
import com.AnLa.NET.DocNet;
import com.AnLa.NET.Email;
import com.DAS.Tools.ALEmail;

@SpringBootApplication
public class DASCourseApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DocNet authentication = new DocNet("https://github.com/TranTienSy/tesst/blob/main/AUTHENTICATION.txt");
		String  hashUsername = authentication.readLine(),
				hashPassword = authentication.readLine(),
				hashEmail = authentication.readLine(),
				hashEPass = authentication.readLine(),
				hashKey = SHA256.Encrypt(authentication.readLine());
		System.setProperty("spring.datasource.username", "sa");//AES.Decrypt(hashUsername, hashKey)); 
		System.setProperty("spring.datasource.password", "");//AES.Decrypt(hashPassword, hashKey)); 
		ALEmail.ZohoMail = new Email(AES.Decrypt(hashEmail, hashKey), AES.Decrypt(hashEPass, hashKey), "smtp.zoho.com");
		
		SpringApplication.run(DASCourseApplication.class, args);
		
	}

}