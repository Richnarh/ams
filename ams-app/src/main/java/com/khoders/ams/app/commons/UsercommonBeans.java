/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.commons;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.AssetCategory;
import com.khoders.ams.app.entities.AssetLocation;
import com.khoders.ams.app.entities.Client;
import com.khoders.ams.app.entities.Department;
import com.khoders.ams.app.entities.Faculty;
import com.khoders.ams.app.services.AssetService;
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
    @Inject private AssetService assetService;
    
    private List<Asset> assetList = new LinkedList<>();
    private List<Faculty> facultyList = new LinkedList<>();
    private List<Department> departmentList = new LinkedList<>();
    private List<Client> clientList = new LinkedList<>();
    private List<AssetCategory> assetCategoryList = new LinkedList<>();
    private List<AssetLocation> assetLocationList = new LinkedList<>();
    
    @PostConstruct
    public void init()
    {
      assetList = assetService.getAssetList();
      facultyList = assetService.getFacultyList();
      departmentList = assetService.getDepartmentList();
      clientList = assetService.getClientList();
      assetCategoryList = assetService.getAssetCategoryList();
      assetLocationList = assetService.getAssetLocationList();
    }        

    public List<Asset> getAssetList()
    {
        return assetList;
    }

    public List<Faculty> getFacultyList()
    {
        return facultyList;
    }

    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public List<Client> getClientList()
    {
        return clientList;
    }

    public List<AssetCategory> getAssetCategoryList()
    {
        return assetCategoryList;
    }

    public List<AssetLocation> getAssetLocationList()
    {
        return assetLocationList;
    }
    
}
