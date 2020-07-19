package com.primus.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ApplicationService {

    @Autowired
    ApplicationDAO applicationDAO ;

    public  Application getApplication(String appId)
    {
        return  applicationDAO.getApp(appId);
    }
}
