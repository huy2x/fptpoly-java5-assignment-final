package com.DAS.Tools;

import com.AnLa.NET.Email;

public class ALEmail {
	public static Email ZohoMail;
	
	public static String HTMLTemplate = 
			"<body style=\"min-height: 100vh; width: 100%; margin: 0 auto; background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);\">\r\n"
			+ "	<div style=\"font-family: Helvetica,Arial,sans-serif;overflow:auto;line-height:2;text-align:center;padding: 0.2em;\">\r\n"
			+ "		<img src=\"https://raw.githubusercontent.com/AnLaVN/DAS_Courses/Releases/DAS_Courses_Logo/Logo.png\" style=\"height: 25%; max-height: 250px; margin: 20px auto;\">\r\n"
			+ "		<div style=\"border-bottom:2px solid rgb(215, 215, 215)\">\r\n"
			+ "			<a href=\"https://github.com/AnLaVN/DAS_Courses\" style=\"font-size:1.4em;color: #0f4058;text-decoration:none;font-weight:600\">DAS_Course</a>\r\n"
			+ "		</div>\r\n"
			+ "		<p style=\"font-size:1.5em\">Hi, USERNAME</p>\r\n"
			+ "		<p>CONTENT</p>\r\n"
			+ "		<h2 style=\"background: #00466a;margin: 0 auto;width: max-content; padding: 0 10px;color: #fff;border-radius: 4px;\">\r\n"
			+ "			OTPCODE</h2><br>\r\n"
			+ "		<i style=\"font-size:1em;\">WARNING</i>\r\n"
			+ "		<hr style=\"border:none;border-top:2px solid rgb(215, 215, 215)\" />\r\n"
			+ "		<p style=\"font-size:0.9em;\">THANK</p>\r\n"
			+ "	</div>\r\n"
			+ "</body>";
	
	public static String getHTMLString(String text) {
		String usernameUnicode = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); int value = c;
            usernameUnicode += "&#" + value + ";";
        }
        return usernameUnicode;
	}
}