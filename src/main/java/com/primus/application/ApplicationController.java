package com.primus.application;

import com.primus.bologin.BOLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/application")
@RestController
public class ApplicationController {


    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/getMenus", method = RequestMethod.GET)
    private ResponseEntity<String> checkLogin()
    {
        String ret  = getApplicationAndMenus().toJSON();
        ResponseEntity entity =  new ResponseEntity<String>(ret,HttpStatus.OK);
        return  entity;

    }

    private  Application getApplicationAndMenus()
    {
        return applicationService.getApplication("BOCHIT");


    }
    }
