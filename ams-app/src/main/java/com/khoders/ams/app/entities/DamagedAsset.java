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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "damaged_asset")
public class DamagedAsset extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "asset_category", referencedColumnName = "id")
    @ManyToOne
    private AssetCategory assetCategory;

    @JoinColumn(name = "asset", referencedColumnName = "id")
    @ManyToOne
    private Asset asset;
    
    @JoinColumn(name = "asset_location", referencedColumnName = "id")
    @ManyToOne
    private AssetLocation assetLocation;
    
    @Column(name = "description")
    private String description;

    public AssetCategory getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory)
    {
        this.assetCategory = assetCategory;
    }

    public Asset getAsset()
    {
        return asset;
    }

    public void setAsset(Asset asset)
    {
        this.asset = asset;
    }

    public AssetLocation getAssetLocation()
    {
        return assetLocation;
    }

    public void setAssetLocation(AssetLocation assetLocation)
    {
        this.assetLocation = assetLocation;
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
