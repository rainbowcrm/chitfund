package com.primus.metadata.model;

import com.primus.metadata.ServiceFactory;
import com.primus.generic.BusinessModel;
import com.primus.generic.GenericService;
import com.techtrade.rads.framework.model.abstracts.ModelObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListModel  {

    private String [] fieldStr =  new String[] {"Code","Name","Description","Email","Phone"};
    public Map getPage(String entity)
    {
        GenericService genericService = (GenericService) ServiceFactory.services().instantiateObject("genericService") ;
        genericService.listData("MetadataEntity",0,0, " where name = '" + entity + "'",null,null);
        Map ans = new LinkedHashMap();
        List<String> fields = new ArrayList<>();
        List<Map> data = new ArrayList<>();
        for (String field : fieldStr )
        {
            fields.add(field);
        }
        ans.put("fields",fields);


        List <BusinessModel> entries  = genericService.listData(entity,0,9999,null,null,null);
        for ( BusinessModel entry : entries )
        {
            data.add(entry.toMap());
        }
        ans.put("data",data);
        return ans;


    }

}
