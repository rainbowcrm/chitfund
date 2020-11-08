package com.primus.common.finitevalue.service;

import com.primus.common.finitevalue.dao.FiniteValueDAO;
import com.primus.common.finitevalue.model.FiniteValue;
import com.primus.generic.BusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FiniteValueService {

    @Autowired
    FiniteValueDAO finiteValueDAO ;


    public List<FiniteValue> getAllFVbyGroup(BusinessContext context, String groupCode)
    {
        return  finiteValueDAO.getAllFVbyGroup(groupCode);
    }

}
