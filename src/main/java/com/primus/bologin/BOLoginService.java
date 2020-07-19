package com.primus.bologin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class BOLoginService {

    @Autowired
    BOLoginDAO loginDAO;

    public BOLogin getById(String userId) {
        return loginDAO.getByUserId(userId) ;
    }
}
