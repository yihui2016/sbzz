package com.springboot.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.springboot.springboot.security.authentications.UserAuthentication;
import com.springboot.springboot.service.impl.SessionBiz;

@Component
public class SessionTokenVerifier {
	@Autowired
	SessionBiz sessionBiz;
	
    public boolean contains(String token) {
    	return sessionBiz.getSession(token) != null;
    }

    public Authentication retrieve(String token) {
            return (Authentication) new UserAuthentication(sessionBiz.getSession(token));
    }
    

}
