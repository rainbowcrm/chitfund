package com.primus.metadata.model;

import com.techtrade.rads.framework.annotations.RadsPropertySet;
import com.techtrade.rads.framework.model.abstracts.ModelObject;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name ="ENTITY_FIELDS")
public class Field extends ModelObject {


    protected Date lastUpdateDate;
    protected Date createdDate;
    protected String createdBy;
    protected String lastUpdatedBy;


    protected int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @RadsPropertySet(isPK = true)
    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

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
    }

    String fieldName;
    String labelKey;
    String jsonTag ;
    String populator;
    MetadataEntity entity ;
    String labelValue;
    String displayControl;
    Integer screenWidth ;

    @Column(name = "UI_LABEL_VALUE")
    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    @Column(name = "DISPLAY_CONTROL")
    public String getDisplayControl() {
        return displayControl;
    }

    public void setDisplayControl(String displayControl) {
        this.displayControl = displayControl;
    }

    @Column(name = "SCREEN_WIDTH")
    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    @Column(name = "UI_LABEL_KEY")
    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String label) {
        this.labelKey = label;
    }

    @Column(name = "JSON_TAG")
    public String getJsonTag() {
        return jsonTag;
    }

    public void setJsonTag(String jsonTag) {
        this.jsonTag = jsonTag;
    }



    @Column(name = "VALUE_POPULATOR")
    public String getPopulator() {
        return populator;
    }

    public void setPopulator(String populator) {
        this.populator = populator;
    }

    @Column(name = "FIELD_NAME")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name  ="ENTITY_NAME")
    @RadsPropertySet(excludeFromXML = true,excludeFromMap = true,excludeFromJSON = true)
    public MetadataEntity getEntity() {
        return entity;
    }

    public void setEntity(MetadataEntity entity) {
        this.entity = entity;
    }
}
