package com.primus.common;

import com.primus.generic.BusinessContext;
import com.primus.generic.BusinessModel;
import com.techtrade.rads.framework.model.transaction.TransactionResult;

public interface IValidator {


    public default TransactionResult basicValidation(BusinessModel model, BusinessContext context)
    {
        return new TransactionResult(TransactionResult.Result.SUCCESS);
    }

    public  default  TransactionResult advancedValidation(BusinessModel model, BusinessContext context)
    {
        return new TransactionResult(TransactionResult.Result.SUCCESS);
        
    }
}


