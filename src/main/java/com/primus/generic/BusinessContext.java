package com.primus.generic;

import com.techtrade.rads.framework.context.IRadsContext;
import org.springframework.security.core.context.SecurityContext;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class BusinessContext implements IRadsContext, Serializable {

    String user;
    Locale locale = Locale.US;

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String s) {
        this.user =s;

    }

    @Override
    public Map getProperties() {
        return null;
    }

    @Override
    public void setProperties(Map map) {

    }

    @Override
    public void addProperty(String s, String s1) {

    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public void setLocale(Locale locale) {

    }

    public static BusinessContext createContext(SecurityContext securityContext)
    {
        BusinessContext context = new BusinessContext();
        context.setUser((String)securityContext.getAuthentication().getPrincipal());
        return context;

    }
}
