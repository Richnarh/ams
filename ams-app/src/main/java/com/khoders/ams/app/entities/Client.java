/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import com.khoders.resource.enums.ClientType;
import com.khoders.resource.utilities.SystemUtils;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "client")
public class Client extends UserAccountRecord implements Serializable
{
    @Column(name = "client_name")
    private String clientName;
    
    @Column(name = "code")
    private String clientCode;
    
    @Column(name = "client_type")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "description")
    @Lob
    private String description;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public ClientType getClientType()
    {
        return clientType;
    }

    public void setClientType(ClientType clientType)
    {
        this.clientType = clientType;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getClientCode()
    {
        return clientCode;
    }

    public void setClientCode(String clientCode)
    {
        this.clientCode = clientCode;
    }

    @Override
    public String toString()
    {
        return clientName;
    }
    
      public void genCode()
    {
        if (getClientCode() != null)
        {
            setClientCode(getClientCode());
        } else
        {
            setClientCode(SystemUtils.generateCode());
        }
    }  
}
