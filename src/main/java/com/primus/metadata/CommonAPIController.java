package com.primus.metadata;

import com.primus.metadata.model.ListModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/commonui")
@RestController
public class CommonAPIController {

    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    public ResponseEntity<Map> getListPageMeta(@RequestParam String pageid)
    {
        ListModel listModel = new ListModel();
        Map ret = listModel.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }

    @RequestMapping(value = "/getCreatePage", method = RequestMethod.GET)
    public ResponseEntity<Map> getCreatePageMeta(@RequestParam String pageid)
    {
        ListModel listModel = new ListModel();
        Map ret = listModel.getPage(pageid);
        ResponseEntity entity =  new ResponseEntity<Map>(ret, HttpStatus.OK);
        return  entity;

    }
}
