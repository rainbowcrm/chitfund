package com.primus.generic;

import com.primus.common.PrimusEntityFactory;
import com.techtrade.rads.framework.model.abstracts.RadsError;
import com.techtrade.rads.framework.model.transaction.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
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
    public ResponseEntity<Map> createObject(  @RequestBody Map<String,Object> input,@RequestParam  String entity)
    {
        BusinessContext context = BusinessContext.createContext(SecurityContextHolder.getContext());

        String entityClass = primusEntityFactory.getEntityClass(entity);
        context.setCurrentEntity(entity);
        BusinessModel model = (BusinessModel) BusinessModel.instantiateObjectfromMap(input,entityClass,context);
        TransactionResult result = genericService.create(model,context);
        if (!result.hasErrors()) {
            ResponseEntity responseEntity = new ResponseEntity<Map>(model.toMap(), HttpStatus.OK);
            return responseEntity;
        }else
        {
            Map errorMap = new LinkedHashMap();
            for (RadsError error : result.getErrors()) {
                errorMap.put(error.getCode(),error.getMessage()) ;
            }
            ResponseEntity responseEntity = new ResponseEntity<Map>(errorMap, HttpStatus.BAD_REQUEST);
            return responseEntity ;

        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Map> updateObject(  @RequestBody Map<String,Object> input,@RequestParam  String entity)
    {
        BusinessContext context = BusinessContext.createContext(SecurityContextHolder.getContext());
        context.setCurrentEntity(entity);
        String entityClass = primusEntityFactory.getEntityClass(entity);
        BusinessModel model = (BusinessModel) BusinessModel.instantiateObjectfromMap(input,entityClass,context);
        genericService.update(model,context);
        ResponseEntity responseEntity =  new ResponseEntity<Map>(model.toMap(), HttpStatus.OK);
        return responseEntity;

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List> listObjects(@RequestParam  String entity ,
                                            @RequestParam Integer fromRec  , @RequestParam Integer toRec )
    {
        List retValues = genericService.listData(entity,fromRec,toRec,null,null);
        ResponseEntity responseEntity =  new ResponseEntity<List>(retValues, HttpStatus.OK);
        return responseEntity;

    }
}
