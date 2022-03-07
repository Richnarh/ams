/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.services;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.DamagedAsset;
import com.khoders.ams.app.jbeans.reportModels.AssetModel;
import com.khoders.ams.app.jbeans.reportModels.DamagedAssetModel;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author richa
 */
@Stateless
public class XtractService {
     public List<AssetModel> extractToAsset(List<Asset> assetList)
     {
         List<AssetModel> assetModelList = new LinkedList<>();
         for (Asset asset : assetList) 
         {
             AssetModel assetModel = new  AssetModel();
             
             assetModel.setAssetCategory(asset.getAssetCategory().getCategoryName());
             assetModel.setAssetName(asset.getAssetName());
             assetModel.setExpectedLifeSpan(asset.getExpectedLifeSpan());
             assetModel.setRegDate(asset.getRegDate());
             assetModel.setAssetStatus(asset.getAssetStatus().getLabel());
             assetModel.setAssetCode(asset.getAssetCode());
             assetModel.setDescription(asset.getDescription());
             if(asset.getAssetCategory() != null)
             {
               assetModel.setAssetCategory(asset.getAssetCategory().getCategoryName());  
             }
             if(asset.getAssetLocation() != null)
             {
               assetModel.setAssetLocation(asset.getAssetLocation().getLocationName());  
             }
             if(asset.getDepartment() != null)
             {
               assetModel.setDepartment(asset.getDepartment().getDeptName());  
             }
             assetModelList.add(assetModel);
         }
         
         return assetModelList;
     }
 
     public List<DamagedAssetModel> extractToDamagedAsset(List<DamagedAsset> damagedAssetList)
     {
         List<DamagedAssetModel> damagedAssetModelList = new LinkedList<>();
         
         for(DamagedAsset damagedAsset : damagedAssetList) {
             DamagedAssetModel damagedAssetModel = new DamagedAssetModel();
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
             
             damagedAssetModelList.add(damagedAssetModel);
         }
         return damagedAssetModelList;
         
     }
}