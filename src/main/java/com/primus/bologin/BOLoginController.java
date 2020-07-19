package com.primus.bologin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:20220", maxAge = 3600)
@RequestMapping("/api/login")
@RestController
public class BOLoginController {

    @Autowired
    BOLoginService boLoginService;

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
        private ResponseEntity<Map> checkLogin(@RequestBody Map<String,String> input)
        {
            input.keySet().forEach(key -> {
                System.out.println(key + ":" + input.get(key));
            });
            Map ret = new LinkedHashMap();
            String userId = input.get(("userId") );
            String password = input.get("pwd");
            BOLogin boLogin = boLoginService.getById(userId);
            if (boLogin !=null  && boLogin.getPassword().equals(password) )
            {
                ret  = boLogin.toMap();
                ResponseEntity entity =  new ResponseEntity<Map>(ret,HttpStatus.OK);
                ret.put("sessionId","909999");
                ret.remove("password");
                return  entity;

            }else{
                ResponseEntity entity =  new ResponseEntity<Map>(ret,HttpStatus.UNAUTHORIZED);

                return  entity;
            }




        }
}
