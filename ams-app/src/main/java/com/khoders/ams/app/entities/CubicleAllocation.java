/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "cubicle_allocation")
public class CubicleAllocation extends UserAccountRecord implements Serializable
{
   @Column(name = "cubicle_name")
   private String cubicleName;
   
   @JoinColumn(name = "vendor", referencedColumnName = "id")
   @ManyToOne
   private Vendor vendor;
   
   @Column(name = "description")
   @Lob
   private String description;

    public String getCubicleName()
    {
        return cubicleName;
    }

    public void setCubicleName(String cubicleName)
    {
        this.cubicleName = cubicleName;
    }

    public Vendor getVendor()
    {
        return vendor;
    }

    public void setVendor(Vendor vendor)
    {
        this.vendor = vendor;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
}
