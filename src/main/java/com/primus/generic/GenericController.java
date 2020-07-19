package com.primus.generic;

import com.primus.entity.PrimusEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/generic")
@RestController
public class GenericController {

    @Autowired
    GenericService genericService ;

    @Autowired
    PrimusEntityFactory primusEntityFactory;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Map> createObject(@RequestBody Map<String,Object> input,@RequestParam  String entity)
    {
        BusinessContext context = new BusinessContext();
        String entityClass = primusEntityFactory.getEntityClass(entity);
        BusinessModel model = (BusinessModel) BusinessModel.instantiateObjectfromMap(input,entityClass,context);
        ResponseEntity responseEntity =  new ResponseEntity<Map>(model.toMap(), HttpStatus.OK);
        return responseEntity;

    }
}
