package com.primus.metadata.model;

import com.techtrade.rads.framework.annotations.RadsPropertySet;
import com.techtrade.rads.framework.model.abstracts.ModelObject;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "ENTITIES")
public class MetadataEntity extends ModelObject {


 /*   protected Date lastUpdateDate;
    protected Date createdDate;
    protected String createdBy;
    protected String lastUpdatedBy;*/



/*
    @Column(name = "CREATED_DATE")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Column(name = "LAST_UPDATED_DATE")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "LAST_UPDATED_BY")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }


    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }*/

    String name;
    boolean hasSub ;
    MetadataEntity parentEntity ;
    Collection<Field> fields ;
    String className;
    String pkType ;

    @Id
    @Column(name = "ENTITY_NAME")
    @RadsPropertySet(isPK = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "HAS_SUB")
    public boolean isHasSub() {
        return hasSub;
    }

    public void setHasSub(boolean hasSub) {
        this.hasSub = hasSub;
    }

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name  ="PARENT_ENTITY")
    public MetadataEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(MetadataEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    @RadsPropertySet(excludeFromMap = true, excludeFromXML = true  , excludeFromJSON =  true)
    @OneToMany(cascade= CascadeType.ALL, mappedBy = "entity")
    public Collection<Field> getFields() {
        return fields;
    }

    public void setFields(Collection<Field> fields) {
        this.fields = fields;
    }

    @Column(name = "CLASSNAME")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Column(name = "PK_TYPE")
    public String getPkType() {
        return pkType;
    }

    public void setPkType(String pkType) {
        this.pkType = pkType;
    }
}
