/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.commons;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.services.AssetService;
import com.khoders.resource.jpa.CrudApi;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "usercommonBeans")
@SessionScoped
public class UsercommonBeans implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    
    private List<Asset> assetList = new LinkedList<>();
    
    @PostConstruct
    private void init()
    {
      assetList = assetService.getAssetList();
    }        

    public List<Asset> getAssetList()
    {
        return assetList;
    }
    
    
}
