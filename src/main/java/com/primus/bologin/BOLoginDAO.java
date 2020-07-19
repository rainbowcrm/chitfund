package com.primus.bologin;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class BOLoginDAO {

    @PersistenceContext
    protected EntityManager em;

    public BOLogin getByUserId( String userId) {
        Class className =  BOLogin.class;

        return (BOLogin)em.find(className,userId);
    }
}
