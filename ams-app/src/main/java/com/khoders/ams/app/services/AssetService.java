/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.services;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.AssetCategory;
import com.khoders.ams.app.entities.AssetRegistration;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.resource.jpa.CrudApi;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author richa
 */
@Stateless
public class AssetService
{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    
    public List<Asset> getAssetList()
    {
        String queryString = "SELECT e FROM Asset e WHERE e.userAccount";
        return crudApi.getEm().createQuery(queryString, Asset.class).getResultList();
    }
    
    public List<AssetRegistration> getRegisteredAssetList()
    {
        try
        {
            String queryString = "SELECT e FROM AssetRegistration e WHERE e.userAccount=?1";
            TypedQuery<AssetRegistration> typedQuery = crudApi.getEm().createQuery(queryString, AssetRegistration.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public List<AssetCategory> getAssetCategoryList()
    {
        try
        {
            String queryString = "SELECT e FROM AssetCategory e WHERE e.userAccount=?1";
            TypedQuery<AssetCategory> typedQuery = crudApi.getEm().createQuery(queryString, AssetCategory.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
