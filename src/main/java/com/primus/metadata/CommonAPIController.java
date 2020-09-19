package com.primus.metadata;

import com.primus.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/commonui")
@RestController
public class CommonAPIController {

    @Autowired
    MetadataService metadataService ;

    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    public ResponseEntity<Map> getListPageMeta(@RequestParam String pageid)
    {
        Map ret = metadataService.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }

    @RequestMapping(value = "/getCreatePage", method = RequestMethod.GET)
    public ResponseEntity<Map> getCreatePageMeta(@RequestParam String pageid)
    {
        Map ret = metadataService.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }
}
