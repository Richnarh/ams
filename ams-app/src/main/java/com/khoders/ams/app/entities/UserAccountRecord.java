/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import com.khoders.resource.jpa.BaseModel;
import com.khoders.resource.utilities.SystemUtils;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author richa
 */
@MappedSuperclass
public class UserAccountRecord extends BaseModel
{
    @ManyToOne
    @JoinColumn(name = "user_account", referencedColumnName = "id")
    private UserAccount userAccount;
    
    @Column(name = "reference_no")
    private String referenceNo;

    public UserAccount getUserAccount()
    {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount)
    {
        this.userAccount = userAccount;
    }

    public String getReferenceNo()
    {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo)
    {
        this.referenceNo = referenceNo;
    }
    
    public void genCode()
    {
        if (getReferenceNo() != null)
        {
            setReferenceNo(getReferenceNo());
        } else
        {
            setReferenceNo(SystemUtils.generateCode());
        }
    }
}
