package com.primus.metadata;

import com.primus.generic.BusinessModel;
import com.primus.generic.GenericService;
import com.primus.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/commonui")
@RestController
public class CommonAPIController {

    @Autowired
    MetadataService metadataService ;

    @Autowired
    GenericService genericService ;

    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    public ResponseEntity<Map> getListPageMeta(@RequestParam String pageid)
    {
        Map ret = metadataService.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }

    @RequestMapping(value = "/getDataFromPK", method = RequestMethod.GET)
    public ResponseEntity<Map> getDataFromPK(@RequestParam String entity,  @RequestParam String pk)
    {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }
        BusinessModel model = genericService.fetchData(entity,pk,null);
        Map ret = model.toMap() ;
        ResponseEntity responseEntity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  responseEntity;

    }


    @RequestMapping(value = "/getCreatePage", method = RequestMethod.GET)
    public ResponseEntity<Map> getCreatePageMeta(@RequestParam String pageid)
    {
        Map ret = metadataService.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }
}
