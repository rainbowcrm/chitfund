package com.primus.generic;

import com.primus.common.IValidator;
import com.primus.metadata.ServiceFactory;
import com.primus.metadata.model.MetadataEntity;
import com.primus.metadata.service.MetadataService;
import com.techtrade.rads.framework.model.abstracts.RadsError;
import com.techtrade.rads.framework.model.transaction.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GenericService {

    @Autowired
    MetadataService metadataService;

    @Autowired
    GenericDAO genericDAO;

    public TransactionResult create(BusinessModel model, BusinessContext context) {
        try {
            IValidator currentValidator = getValidator(context.getCurrentEntity());
            TransactionResult result = currentValidator.basicValidation(model, context);
            if (result.hasErrors()) {
                return result;
            }

            result = currentValidator.advancedValidation(model, context);
            if (result.hasErrors()) {
                return result;
            }
        }catch (Exception ex)
        {
            TransactionResult result = new TransactionResult(TransactionResult.Result.FAILURE);
            result.addError(new RadsError("","system error! please contact Admin"));
            return result;
        }

        model.setCreatedDate(new java.util.Date());
        model.setCreatedBy(context.getUser());
        model.setLastUpdatedBy(context.getUser());
        model.setLastUpdateDate(new java.util.Date());
        genericDAO.create(model);
        //Logger.logDebug("Object Created= " + object.toJSON() + "\n Context=" + productContext.toString(), this.getClass());
        return new TransactionResult();
    }


    public GenericDAO getDAO() {
        return genericDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TransactionResult update(BusinessModel model, BusinessContext context) {


        model.setLastUpdatedBy(context.getUser());
        model.setLastUpdateDate(new java.util.Date());
        genericDAO.update(model);
        return new TransactionResult();
    }

    public long getTotalRecordCount(String entity, String whereCondition) {
        return genericDAO.getTotalRecordCount(entity, whereCondition);
    }

    public List<BusinessModel> listData(String entity, int from, int to, String whereCondition, String orderby) {
        GenericDAO dao = getDAO();
        return dao.listData(entity, from, to, whereCondition, null);
    }

    public BusinessModel fetchData(String entity, String pk) {
        GenericDAO dao = getDAO();
        MetadataEntity metadataEntity = metadataService.getMetadata(entity);
        try {
            if (metadataEntity.getPkType().equalsIgnoreCase("ID") || metadataEntity.getPkType().equalsIgnoreCase("INTEGER"))
                return dao.getById(Class.forName(metadataEntity.getClassName()), Integer.parseInt(pk));
            else
                return dao.getById(Class.forName(metadataEntity.getClassName()), pk);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    protected IValidator getValidator(String entity)
    {
        MetadataEntity metadataEntity = metadataService.getMetadata(entity) ;
        String validator = metadataEntity.getValidatorName();
        IValidator iValidator = (IValidator) ServiceFactory.services().instantiateObject(validator);
        return iValidator;
    }
}