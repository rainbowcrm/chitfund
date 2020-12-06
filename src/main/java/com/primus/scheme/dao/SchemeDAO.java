package com.primus.scheme.dao;

import com.primus.generic.BusinessContext;
import com.primus.generic.BusinessModel;
import com.primus.generic.GenericDAO;
import com.primus.scheme.model.Scheme;
import com.techtrade.rads.framework.utils.Utils;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class SchemeDAO extends GenericDAO {

    public List<Scheme> getAllActiveSchemes(BusinessContext context)
    {
        Query query =  em.createQuery("from Scheme where status.code in " +
                "('SCHMINIT','SCHMREADY','SCHMACTIVE')" );
        query.setFirstResult(1);
        query.setMaxResults(999);
        List<Scheme> ans = query.getResultList();

        return ans;

    }
}
