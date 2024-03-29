package com.primus.scheme.model;

import com.primus.common.finitevalue.model.FiniteValue;
import com.primus.generic.BusinessModel;
import com.primus.schemetype.model.SchemeType;
import com.techtrade.rads.framework.annotations.RadsPropertySet;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="SCHEMES")
public class Scheme  extends BusinessModel {
    String code;
    String description;
    SchemeType schemeType ;
    FiniteValue status;
    Date startDate;
    Date endDate ;
    Timestamp nextAuctionDate ;
    Integer auctionInterval ;
    String comments;

    @Column(name  ="CODE")
    @RadsPropertySet(isBK = true)
    public String getCode() {
        return code;
    }

    @RadsPropertySet(isBK = true)
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
    @JoinColumn(name  ="SCHEME_TYPE")
    //@RadsPropertySet(useBKForMap = true,useBKForJSON = true,useBKForXML = true,usePKForMap = true,usePKForJSON = true,usePKForXML = true)
    public SchemeType getSchemeType() {
        return schemeType;
    }

    //@RadsPropertySet(useBKForMap = true,useBKForJSON = true,useBKForXML = true,usePKForMap = true,usePKForJSON = true,usePKForXML = true)
    public void setSchemeType(SchemeType schemeType) {
        this.schemeType = schemeType;
    }

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name  ="STATUS")
    //@RadsPropertySet(useBKForMap = true,useBKForJSON = true,useBKForXML = true,usePKForMap = true,usePKForJSON = true,usePKForXML = true)
    public FiniteValue getStatus() {
        return status;
    }

    //@RadsPropertySet(useBKForMap = true,useBKForJSON = true,useBKForXML = true,usePKForMap = true,usePKForJSON = true,usePKForXML = true)
    public void setStatus(FiniteValue status) {
        this.status = status;
    }

    @Column(name  ="START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name  ="END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name  ="NEXT_AUCTION_DATE")
    public Timestamp getNextAuctionDate() {
        return nextAuctionDate;
    }

    public void setNextAuctionDate(Timestamp nextAuctionDate) {
        this.nextAuctionDate = nextAuctionDate;
    }



    @Column(name  ="COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
