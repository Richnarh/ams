/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.AssetLocation;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.ams.app.services.AssetService;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richard
 */
@Named(value = "assetLocationController")
@SessionScoped
public class AssetLocationController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private AssetLocation assetLocation = new AssetLocation();
    private List<AssetLocation> assetLocationList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       assetLocationList = assetService.getAssetLocationList();
       clearAssetLocation();
    }
    
    public void saveAssetLocation()
    {
        try
        {
            if(crudApi.save(assetLocation) != null)
            {
                assetLocationList = CollectionList.washList(assetLocationList, assetLocation);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearAssetLocation();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, Msg.FAILED_MESSAGE, null)); 
               
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void editAssetLocation(AssetLocation assetLocation)
    {
       this.assetLocation = assetLocation;
       optionText = "Update";
    }
    
    public void deleteAssetLocation(AssetLocation assetLocation)
    {
        try
        {
           if(crudApi.delete(assetLocation))
           {
               assetLocationList.remove(assetLocation);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearAssetLocation()
    {
       assetLocation = new AssetLocation();
       assetLocation.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public AssetLocation getAssetLocation()
    {
        return assetLocation;
    }

    public void setAssetLocation(AssetLocation assetLocation)
    {
        this.assetLocation = assetLocation;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<AssetLocation> getAssetLocationList()
    {
        return assetLocationList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
