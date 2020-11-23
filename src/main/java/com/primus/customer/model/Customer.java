package com.primus.customer.model;

import com.primus.common.finitevalue.model.FiniteValue;
import com.primus.generic.BusinessModel;
import com.techtrade.rads.framework.annotations.RadsPropertySet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="CUSTOMERS")
public class Customer extends BusinessModel {

    String email;
    String phone;
    String firstName;
    String lastName;
    Date DateOfBirth ;
    String address1;
    String address2 ;
    String city;
    String state ;
    String zipCode ;
    FiniteValue status;
    Boolean verified ;
    String comments;

    @Column(name  ="EMAIL")
    @RadsPropertySet(isBK = true)
    public String getEmail() {
        return email;
    }

    @RadsPropertySet(isBK = true)
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name  ="PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name  ="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name  ="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name  ="DATEOFBIRTH")
    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    @Column(name  ="ADDRESS1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name  ="ADDRESS2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name  ="CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name  ="STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name  ="ZIPCODE")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name  ="STATUS")
    public FiniteValue getStatus() {
        return status;
    }

    public void setStatus(FiniteValue status) {
        this.status = status;
    }

    @Column(name  ="IS_VERIFIED")
    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Column(name  ="COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
