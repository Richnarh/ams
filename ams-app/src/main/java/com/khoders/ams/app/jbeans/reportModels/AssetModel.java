package com.khoders.ams.app.jbeans.reportModels;

import java.time.LocalDate;

/**
 *
 * @author richa
 */
public class AssetModel {
    private String assetCode;
    private LocalDate regDate;
    private String assetLocation;
    private String assetStatus;
    private String assetName;
    private String expectedLifeSpan;
    private String assetCategory;
    private String department;
    private String description;
   
    public String getAssetCode()
    {
        return assetCode;
    }

    public void setAssetCode(String assetCode)
    {
        this.assetCode = assetCode;
    }

    public LocalDate getRegDate()
    {
        return regDate;
    }

    public void setRegDate(LocalDate regDate)
    {
        this.regDate = regDate;
    }

    public String getAssetLocation()
    {
        return assetLocation;
    }

    public void setAssetLocation(String assetLocation)
    {
        this.assetLocation = assetLocation;
    }

    public String getAssetStatus()
    {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus)
    {
        this.assetStatus = assetStatus;
    }

    public String getAssetName()
    {
        return assetName;
    }

    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }

    public String getExpectedLifeSpan()
    {
        return expectedLifeSpan;
    }

    public void setExpectedLifeSpan(String expectedLifeSpan)
    {
        this.expectedLifeSpan = expectedLifeSpan;
    }

    public String getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory)
    {
        this.assetCategory = assetCategory;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
