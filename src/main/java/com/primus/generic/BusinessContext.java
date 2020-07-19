package com.primus.generic;

import com.techtrade.rads.framework.context.IRadsContext;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class BusinessContext implements IRadsContext, Serializable {


    @Override
    public String getUser() {
        return null;
    }

    @Override
    public void setUser(String s) {

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
}
