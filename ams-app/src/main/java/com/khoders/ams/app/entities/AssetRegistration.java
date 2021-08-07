/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import com.khoders.ams.app.entities.enums.AssetStatus;
import com.khoders.resource.utilities.SystemUtils;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "asset_registration")
public class AssetRegistration extends UserAccountRecord implements Serializable
{
    @Column(name = "asset_code")
    private String assetCode;
    
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    
    @Column(name = "asset_location")
    private String assetLocation;
    
    @Column(name = "asset_status")
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;
    
    @JoinColumn(name = "asset", referencedColumnName = "id")
    @ManyToOne
    private Asset asset;
    
    @JoinColumn(name = "asset_type", referencedColumnName = "id")
    @ManyToOne
    private AssetCategory assetCategory;

    public String getAssetCode()
    {
        return assetCode;
    }

    public void setAssetCode(String assetCode)
    {
        this.assetCode = assetCode;
    }
    
    public LocalDate getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate)
    {
        this.registrationDate = registrationDate;
    }
    
    public String getAssetLocation()
    {
        return assetLocation;
    }

    public void setAssetLocation(String assetLocation)
    {
        this.assetLocation = assetLocation;
    }

    public AssetCategory getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory)
    {
        this.assetCategory = assetCategory;
    }
    
    public void genCode()
    {
        if(getAssetCode()!= null)
        {
           setAssetCode(getAssetCode());
        }
        else
        {
            setAssetCode(SystemUtils.generateCode());
        }
    }
}
