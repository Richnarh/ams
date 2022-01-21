package com.khoders.ams.app.jbeans.reportModels;

import java.time.LocalDate;

/**
 *
 * @author richa
 */
public class AssetModel {
    private String serialNumber;
    private String assetName;
    private double unitCost;
    private int quantity;
    private int expectedLifeSpan;
    private LocalDate purchasedDate;
    private String client;
    private String assetCategory;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpectedLifeSpan() {
        return expectedLifeSpan;
    }

    public void setExpectedLifeSpan(int expectedLifeSpan) {
        this.expectedLifeSpan = expectedLifeSpan;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }
    
}
