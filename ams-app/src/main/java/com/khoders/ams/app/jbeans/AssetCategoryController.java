/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.AssetCategory;
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
@Named(value = "assetCategoryController")
@SessionScoped
public class AssetCategoryController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private AssetCategory assetCategory = new AssetCategory();
    private List<AssetCategory> assetCategoryList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       assetCategoryList = assetService.getAssetCategoryList();
       clearAssetCategory();
    }
    
    public void saveAssetCategory()
    {
        try
        {
            if(crudApi.save(assetCategory) != null)
            {
                assetCategoryList = CollectionList.washList(assetCategoryList, assetCategory);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearAssetCategory();
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
    
    public void editAssetCategory(AssetCategory assetCategory)
    {
       this.assetCategory = assetCategory;
       optionText = "Update";
    }
    
    public void deleteAssetCategory(AssetCategory assetCategory)
    {
        try
        {
           if(crudApi.delete(assetCategory))
           {
               assetCategoryList.remove(assetCategory);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearAssetCategory()
    {
       assetCategory = new AssetCategory();
       assetCategory.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public AssetCategory getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory)
    {
        this.assetCategory = assetCategory;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<AssetCategory> getAssetCategoryList()
    {
        return assetCategoryList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
