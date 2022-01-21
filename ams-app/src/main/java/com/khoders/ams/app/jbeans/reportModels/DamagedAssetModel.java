/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans.reportModels;

/**
 *DamagedAssetModel
 * @author richa
 */
public class DamagedAssetModel {
    private String assetCategoryName;
    private String assetName;
    private String assetLocationName;
    private String description;

    public String getAssetCategoryName() {
        return assetCategoryName;
    }

    public void setAssetCategoryName(String assetCategoryName) {
        this.assetCategoryName = assetCategoryName;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetLocationName() {
        return assetLocationName;
    }

    public void setAssetLocationName(String assetLocationName) {
        this.assetLocationName = assetLocationName;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
