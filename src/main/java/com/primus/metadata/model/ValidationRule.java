package com.primus.metadata.model;

public class ValidationRule {

    public enum ValidationType {
        MANDATORY, UNIQUE, REFERRED ,  RANGED  , NON_ZERO_POSITIVE, ONLY_PRESENT_FUTUREDATE , ONLY_PASTDATE
    }


    MetadataEntity parentEntity;
    ValidationType validationType ;
    String field;

    String referredEntity;
    String referredField;


    public MetadataEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(MetadataEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    public ValidationType getValidationType() {
        return validationType;
    }

    public void setValidationType(ValidationType validationType) {
        this.validationType = validationType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getReferredEntity() {
        return referredEntity;
    }

    public void setReferredEntity(String referredEntity) {
        this.referredEntity = referredEntity;
    }

    public String getReferredField() {
        return referredField;
    }

    public void setReferredField(String referredField) {
        this.referredField = referredField;
    }


}
