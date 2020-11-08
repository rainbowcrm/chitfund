package com.primus.common.finitevalue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="FINITE_GROUPS")
public class FiniteGroup {
    String groupCode;
    String groupDesc ;

    @Column(name  ="GROUP_CODE")
    @Id
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Column(name  ="DESCRIPTION")
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
}
