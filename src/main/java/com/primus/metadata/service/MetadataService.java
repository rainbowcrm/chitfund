package com.primus.metadata.service;

import com.primus.generic.BusinessModel;
import com.primus.generic.GenericService;
import com.primus.metadata.ServiceFactory;
import com.primus.metadata.dao.MetadataDAO;
import com.primus.metadata.model.MetadataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class MetadataService {

    @Autowired
    MetadataDAO metadataDAO;

    private String [] fieldStr =  new String[] {"Code","Name","Description","Email","Phone"};
    public Map getPage(String entity)
    {
        GenericService genericService = (GenericService) ServiceFactory.services().instantiateObject("genericService") ;
        MetadataEntity metadataEntity = metadataDAO.getEntityDetails(entity);

        Map ans = new LinkedHashMap();
        List<Map> fields = new ArrayList<>();
        List<Map> data = new ArrayList<>();
        if (metadataEntity != null ) {
            metadataEntity.getFields().forEach( field ->{
                fields.add(field.toMap());

            });
            ans.put("fields", fields);
        }


        List <BusinessModel> entries  = genericService.listData(entity,0,9999,null,null,null);
        for ( BusinessModel entry : entries )
        {
            data.add(entry.toMap());
        }
        ans.put("data",data);
        return ans;


    }
}
