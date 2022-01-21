/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.services;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.AssetRegistration;
import com.khoders.ams.app.entities.DamagedAsset;
import com.khoders.ams.app.jbeans.reportModels.AssetModel;
import com.khoders.ams.app.jbeans.reportModels.AssetRegModel;
import com.khoders.ams.app.jbeans.reportModels.DamagedAssetModel;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author richa
 */
@Stateless
public class XtractService {
     public AssetModel extractToAsset(List<Asset> assetList, AssetModel assetModel)
     {
         for (Asset asset : assetList) {
             assetModel.setAssetCategory(asset.getAssetCategory().getCategoryName());
             assetModel.setAssetName(asset.getAssetName());
             if(asset.getClient() != null)
             {
               assetModel.setClient(asset.getClient().getClientName());  
             }
             assetModel.setExpectedLifeSpan(asset.getExpectedLifeSpan());
             assetModel.setPurchasedDate(asset.getPurchasedDate());
             assetModel.setQuantity(asset.getQuantity());
             assetModel.setSerialNumber(asset.getSerialNumber());
             assetModel.setUnitCost(asset.getUnitCost());
         }
         
         return assetModel;
     }
     public AssetRegModel extractToAssetReg(List<AssetRegistration> assetRegistrationList, AssetRegModel assetRegModel)
     {
         for(AssetRegistration registration : assetRegistrationList) {
             assetRegModel.setAssetCode(registration.getAssetCode());
             assetRegModel.setRegistrationDate(registration.getRegistrationDate());
             if(registration.getAssetLocation() != null)
             {
                assetRegModel.setAssetLocation(registration.getAssetLocation().getLocationName()); 
             }
             if(registration.getAsset() != null)
             {
               assetRegModel.setAssetName(registration.getAsset().getAssetName());  
             }
             assetRegModel.setAssetStatus(registration.getAssetStatus().getLabel());
             assetRegModel.setDescription(registration.getDescription());
         }
         
         return assetRegModel;
     }
     public DamagedAssetModel extractToDamagedAsset(List<DamagedAsset> damagedAssetList, DamagedAssetModel damagedAssetModel)
     {
         for(DamagedAsset damagedAsset : damagedAssetList) {
             if(damagedAsset.getAsset() != null)
             {
               damagedAssetModel.setAssetName(damagedAsset.getAsset().getAssetName());  
             }
             if(damagedAsset.getAssetLocation() != null)
             {
                damagedAssetModel.setAssetLocationName(damagedAsset.getAssetLocation().getLocationName()); 
             }
             if(damagedAsset.getAsset() != null)
             {
               damagedAssetModel.setAssetName(damagedAsset.getAsset().getAssetName());  
             }
             damagedAssetModel.setDescription(damagedAsset.getDescription());
         }
         
         return damagedAssetModel;
     }
}