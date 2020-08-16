package com.primus.metadata;

import com.primus.generic.GenericService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory  implements ApplicationContextAware {

    @Autowired
    GenericService genericService ;




    public Object instantiateObject(String obj  )
    {
        if("genericService".equalsIgnoreCase(obj))
            return genericService ;
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
