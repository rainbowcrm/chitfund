package com.primus.metadata;

import com.primus.common.finitevalue.service.FiniteValueService;
import com.primus.generic.GenericService;
import com.primus.generic.GenericValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory  implements ApplicationContextAware {

    @Autowired
    GenericService genericService ;

    @Autowired
    GenericValidator genericValidator ;

    @Autowired
    FiniteValueService finiteValueService ;


    public GenericService getServiceForEntity(String entity)
    {
        return  genericService;
    }

    public Object instantiateObject(String obj  )
    {
        if("genericService".equalsIgnoreCase(obj))
            return genericService ;
        if("genericValidator".equalsIgnoreCase(obj))
            return genericValidator ;
        if("finiteValueService".equalsIgnoreCase(obj))
            return finiteValueService ;


        return genericService;
    }



    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
    public static ServiceFactory services() {
        return applicationContext.getBean(ServiceFactory.class);
    }
}
