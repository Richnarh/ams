/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import com.khoders.ams.app.entities.enums.AssetStatus;
import com.khoders.ams.app.entities.enums.DispatchType;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "asset_dispatch")
public class AssetDispatch extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "asset", referencedColumnName = "id")
    @ManyToOne
    private Asset asset;
    
    @Column(name = "dispatch_date")
    private LocalDate dispatchDate;
    
    @Column(name = "auction_cost")
    private double auctionCost;
    
    @Column(name = "asset_status")
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;
    
    @Column(name = "dispatch_type")
    @Enumerated(EnumType.STRING)
    private DispatchType dispatchType;
    
    @Lob
    @Column(name = "description")
    private String description;

    public Asset getAsset()
    {
        return asset;
    }

    public void setAsset(Asset asset)
    {
        this.asset = asset;
    }

    public LocalDate getDispatchDate()
    {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate)
    {
        this.dispatchDate = dispatchDate;
    }

    public double getAuctionCost()
    {
        return auctionCost;
    }

    public void setAuctionCost(double auctionCost)
    {
        this.auctionCost = auctionCost;
    }

    public AssetStatus getAssetStatus()
    {
        return assetStatus;
    }

    public void setAssetStatus(AssetStatus assetStatus)
    {
        this.assetStatus = assetStatus;
    }

    public DispatchType getDispatchType()
    {
        return dispatchType;
    }

    public void setDispatchType(DispatchType dispatchType)
    {
        this.dispatchType = dispatchType;
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
