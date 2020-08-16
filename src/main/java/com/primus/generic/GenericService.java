package com.primus.generic;

import com.techtrade.rads.framework.model.transaction.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GenericService {

    @Autowired
    GenericDAO genericDAO;
    public TransactionResult create ( BusinessModel model,BusinessContext context)
    {

        GenericDAO dao = getDAO();
       /* model.setCreatedDate(new java.util.Date());
        model.setCreatedBy(context.getUser());
        model.setLastUpdatedBy(context.getUser());
        model.setLastUpdateDate(new java.util.Date());*/
        dao.create(model);
        //  Logger.logDebug("Object Created= " + object.toJSON() + "\n Context=" + productContext.toString(), this.getClass());
        return new TransactionResult();
    }


    public GenericDAO getDAO()
    {
        return genericDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TransactionResult update(BusinessModel model,BusinessContext context) {

        GenericDAO dao = getDAO();

        model.setLastUpdatedBy(context.getUser());
        model.setLastUpdateDate(new java.util.Date());
        dao.create(model);
        return new TransactionResult();
    }


    public List<BusinessModel> listData(String entity, int from , int to , String whereCondition, String orderby,BusinessContext context ) {
        GenericDAO dao = getDAO();
        return dao.listData(entity,from,to,whereCondition,null);
    }


}
