package com.primus.bologin;

import com.techtrade.rads.framework.annotations.RadsPropertySet;
import com.techtrade.rads.framework.model.abstracts.ModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="BO_USERS")
public class BOLogin extends ModelObject {

    String userId;
    String password ;
    String firstName ;
    String lastName;
    String phone;
    String email ;

    @Column(name  ="USER_ID")
    @Id
    @RadsPropertySet(isPK = true, isBK = true)
    public String getUserId() {
        return userId;
    }

    @RadsPropertySet(isPK = true, isBK = true)
    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Column(name  ="PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Column(name  ="PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name  ="EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
