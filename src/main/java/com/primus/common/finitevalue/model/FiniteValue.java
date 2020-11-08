package com.primus.common.finitevalue.model;

import javax.persistence.*;

@Entity
@Table(name="FINITE_VALUES")
public class FiniteValue {

    String code;
    String description;
    FiniteGroup group ;

    @Column(name  ="VALUE_CODE")
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name  ="VALUE_DESC")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name  ="GROUP_CODE")
    public FiniteGroup getGroup() {
        return group;
    }

    public void setGroup(FiniteGroup group) {
        this.group = group;
    }
}
