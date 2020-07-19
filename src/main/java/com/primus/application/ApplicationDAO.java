package com.primus.application;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ApplicationDAO {

    @PersistenceContext
    protected EntityManager em;

    public Application getApp(String appName)
    {
        Class className =  Application.class;


        return (Application) em.find(className,appName);
    }
}
