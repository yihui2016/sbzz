package com.springboot.springboot.security;

import com.google.common.base.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    private SessionTokenVerifier sessionTokenVerifier;
	@Autowired
	private BackendRootTokenVerifier rootTokenVerifier;

    public TokenAuthenticationProvider() {
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<String> token = (Optional) authentication.getPrincipal();
        if (!token.isPresent() || token.get().isEmpty()) {
            throw new BadCredentialsException("Invalid token");
        }
        if (sessionTokenVerifier.contains(token.get())) {
        	return sessionTokenVerifier.retrieve(token.get());
        }else if (rootTokenVerifier.contains(token.get())){
        	return rootTokenVerifier.retrieve(token.get());
        }else{
        	throw new BadCredentialsException("Invalid token or token expired");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(PreAuthenticatedAuthenticationToken.class);
    }
}
