package com.primus.common;


import com.primus.metadata.model.MetadataEntity;
import com.primus.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimusEntityFactory {

    @Autowired
    MetadataService metadataService;

    public String getEntityClass(String entityName)
    {
        MetadataEntity metadataEntity = metadataService.getMetadata(entityName);
        return metadataEntity.getClassName() ;
    }
}
