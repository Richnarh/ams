package com.khoders.ams.app.entities;

import com.khoders.resource.utilities.SystemUtils;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author 
 */
@Entity
@Table(name = "asset")
public class Asset extends UserAccountRecord implements Serializable
{
    @Column(name = "serial_number")
    private String serialNumber;
    
    @Column(name = "asset_name")
    private String assetName;
        
    @Column(name = "unit_cost")
    private double unitCost;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "total_amount")
    private double totalAmount;
    
    @Column(name = "expected_lifespan")
    private int expectedLifeSpan;
    
    @Column(name = "purchased_date")
    private LocalDate purchasedDate;
    
    @JoinColumn(name = "client")
    @ManyToOne
    private Client client;
    
    @JoinColumn(name = "asset_category", referencedColumnName = "id")
    @ManyToOne
    private AssetCategory assetCategory;

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getAssetName()
    {
        return assetName;
    }

    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }

    public double getUnitCost()
    {
        return unitCost;
    }

    public void setUnitCost(double unitCost)
    {
        this.unitCost = unitCost;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public int getExpectedLifeSpan()
    {
        return expectedLifeSpan;
    }

    public void setExpectedLifeSpan(int expectedLifeSpan)
    {
        this.expectedLifeSpan = expectedLifeSpan;
    }

    public LocalDate getPurchasedDate()
    {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate)
    {
        this.purchasedDate = purchasedDate;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }
    
    public AssetCategory getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory)
    {
        this.assetCategory = assetCategory;
    }
   
    @Override
    public String toString()
    {
       return assetName;
    }
    
    
}
