package com.primus.scheme.controller;

import com.primus.common.ObjectFactory;
import com.primus.generic.BusinessContext;
import com.primus.generic.GenericController;
import com.primus.scheme.service.SchemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/calendar")
@RestController

public class SchemeController  extends GenericController {

    @RequestMapping(value = "/calendarview", method = RequestMethod.GET)
    public ResponseEntity<List> listObjects( )
    {
        BusinessContext context = BusinessContext.createContext(SecurityContextHolder.getContext());
        SchemeService schemeService = (SchemeService)
                ObjectFactory.getInstance().getServiceInstance("SchemeService",context);
        List<Map> ls = schemeService.getSnapshot(context);
        ResponseEntity responseEntity = new ResponseEntity<List>(ls, HttpStatus.OK);
        return responseEntity;

    }

}
