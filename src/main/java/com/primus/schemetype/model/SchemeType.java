package com.primus.schemetype.model;

import com.primus.generic.BusinessModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="SCHEME_TYPES")
public class SchemeType extends BusinessModel {

    String code;
    String description;
    String frequency ;
    double pricemony;
    int noParticipants;

    @Column(name  ="CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name  ="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name  ="FREQUENCY")
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Column(name  ="PRICE_MONEY")
    public double getPricemoney() {
        return pricemony;
    }

    public void setPricemoney(double pricemony) {
        this.pricemony = pricemony;
    }


    @Column(name  ="NO_PARTICIPANTS")
    public int getNoParticipants() {
        return noParticipants;
    }

    public void setNoParticipants(int noParticipants) {
        this.noParticipants = noParticipants;
    }
}
