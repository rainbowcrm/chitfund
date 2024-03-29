package com.primus.security;

import com.primus.bologin.BOLogin;
import com.primus.bologin.BOLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    BOLoginService boLoginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        BOLogin boLogin = boLoginService.getById(name) ;
        if (boLogin != null  && boLogin.getPassword().equals(password))
            return new UsernamePasswordAuthenticationToken(
                name, password, new ArrayList<>());
        else
            return  null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
