package com.DAS.Tools;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class ALSession {
	
    private static HttpSession session;
    
    @Autowired
    public ALSession(HttpSession pSession) {
    	ALSession.session = pSession;
    }
	
    public static void setSession(String pName, Object PValue)  { session.setAttribute(pName, PValue);	}
    public static Object getSession(String pName)               { return session.getAttribute(pName);	}
    public static void removeSession(String pName)              { session.removeAttribute(pName);		}
}