package com.springboot.springboot.security.authentications;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.springboot.springboot.constant.AuthorityValue;

public class AnonymousAuthentication implements Authentication{
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "AnonymousAuth";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set r = new HashSet<>();
		r.add(new UserAuthority(AuthorityValue.ROLE1));
		return r;
	}

	@Override
	public Object getCredentials() {
		return new String("credentials");
	}

	@Override
	public Object getDetails() {
		return new String("detail");
	}

	@Override
	public Object getPrincipal() {
		return new String("principal");
	}

	@Override
	public boolean isAuthenticated() {
		return true;// isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}
}