package com.primus.schemetype.model;

import com.primus.common.finitevalue.model.FiniteValue;
import com.primus.generic.BusinessModel;

import javax.persistence.*;

@Entity
@Table(name ="SCHEME_TYPES")
public class SchemeType extends BusinessModel {

    String code;
    String description;
    FiniteValue frequency ;
    double priceMoney;
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

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name  ="FREQUENCY")
    public FiniteValue getFrequency() {
        return frequency;
    }

    public void setFrequency(FiniteValue frequency) {
        this.frequency = frequency;
    }





    @Column(name  ="PRICE_MONEY")
    public double getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(double priceMoney) {
        this.priceMoney = priceMoney;
    }


    @Column(name  ="NO_PARTICIPANTS")
    public int getNoParticipants() {
        return noParticipants;
    }

    public void setNoParticipants(int noParticipants) {
        this.noParticipants = noParticipants;
    }
}
