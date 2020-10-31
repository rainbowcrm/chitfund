package com.primus.metadata.service;

import com.primus.generic.BusinessContext;
import com.primus.generic.BusinessModel;
import com.primus.generic.GenericService;
import com.primus.metadata.ServiceFactory;
import com.primus.metadata.dao.MetadataDAO;
import com.primus.metadata.model.MetadataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MetadataService {

    Map<String,MetadataEntity> cachedMetadata = new HashMap<>();


    @Autowired
    MetadataDAO metadataDAO;

    public Map getPage(String entity, Integer from, Integer to,Map filter)
    {

        int fro = from!=null?from.intValue():0;
        int toI= to!=null?to.intValue():12 ;

        GenericService genericService = (GenericService) ServiceFactory.services().instantiateObject("genericService") ;
        MetadataEntity metadataEntity =  null;
        if (cachedMetadata.get(entity) == null)
        {
            metadataEntity = metadataDAO.getEntityDetails(entity);
            cachedMetadata.put(entity,metadataEntity);
        }
        else
        {
            metadataEntity = cachedMetadata.get(entity);
        }

        StringBuffer whereCondition = new StringBuffer("");

        Map ans = new LinkedHashMap();
        List<Map> fields = new ArrayList<>();
        List<Map> data = new ArrayList<>();
        if (metadataEntity != null ) {
            metadataEntity.getFields().forEach( field ->{
                fields.add(field.toMap());
                if (filter != null && filter.containsKey(field.getJsonTag()))
                {
                    if(!whereCondition.toString().equals(""))
                        whereCondition.append(" and ");
                    else
                        whereCondition.append(" where ");
                    whereCondition.append(field.getJsonTag() + "='" + filter.get(field.getJsonTag()) + "'");
                }


            });
            ans.put("fields", fields);
        }


        List <BusinessModel> entries  = genericService.listData(entity,fro,toI,whereCondition.toString(),null);
        for ( BusinessModel entry : entries )
        {
            data.add(entry.toMap());
        }
        ans.put("data",data);
        long totalRec = genericService.getTotalRecordCount(entity,"");
        ans.put("totalRecords",totalRec);
        return ans;


    }

    public Map getListContent(String entity, Integer from, Integer to)
    {

        int fro = from!=null?from.intValue():0;
        int toI= to!=null?to.intValue():12 ;
        GenericService genericService = (GenericService) ServiceFactory.services().instantiateObject("genericService") ;
        Map ans = new LinkedHashMap();
        List<Map> data = new ArrayList<>();
        List <BusinessModel> entries  = genericService.listData(entity,fro,toI,null,null);
        for ( BusinessModel entry : entries )
        {
            data.add(entry.toMap());
        }
        ans.put("data",data);
        return ans;


    }

    public  MetadataEntity getMetadata(String entity) {
        return cachedMetadata.get(entity) ;
    }
}
