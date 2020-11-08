package com.primus.common.finitevalue.dao;

import com.primus.common.finitevalue.model.FiniteValue;
import com.primus.generic.BusinessModel;
import com.techtrade.rads.framework.utils.Utils;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class FiniteValueDAO {

    @PersistenceContext
    protected EntityManager em;

    public FiniteValue getByCode(String code) {
        return (FiniteValue)em.find(FiniteValue.class,code);
    }

    public List<FiniteValue> getAllFVbyGroup(String groupCode)
    {
        Query query =  em.createQuery("from FiniteValue  where group.groupCode = ?"   );
        query.setParameter(1,groupCode);
        List<FiniteValue> ans = query.getResultList();

        return ans;

    }


}
