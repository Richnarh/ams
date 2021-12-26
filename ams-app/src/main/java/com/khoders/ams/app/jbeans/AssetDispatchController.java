/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.AssetDispatch;
import com.khoders.ams.app.entities.enums.DispatchType;
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
@Named(value = "assetDispatchController")
@SessionScoped
public class AssetDispatchController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private AssetDispatch assetDispatch = new AssetDispatch();
    private List<AssetDispatch> assetDispatchList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    private boolean isAuction = false;
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       assetDispatchList = assetService.getAssetDispatchList();
       clearAssetDispatch();
    }
    
    public void auction(){
        if(assetDispatch.getDispatchType() == DispatchType.AUCTION)
        {
            isAuction = true;
        }
    }
    
    public void saveAssetDispatch()
    {
        try
        {
            assetDispatch.genCode();
            if(crudApi.save(assetDispatch) != null)
            {
                assetDispatchList = CollectionList.washList(assetDispatchList, assetDispatch);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearAssetDispatch();
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
    
    public void editAssetDispatch(AssetDispatch assetDispatch)
    {
       this.assetDispatch = assetDispatch;
       optionText = "Update";
    }
    
    public void deleteAssetDispatch(AssetDispatch assetDispatch)
    {
        try
        {
           if(crudApi.delete(assetDispatch))
           {
               assetDispatchList.remove(assetDispatch);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearAssetDispatch()
    {
       assetDispatch = new AssetDispatch();
       assetDispatch.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public AssetDispatch getAssetDispatch()
    {
        return assetDispatch;
    }

    public void setAssetDispatch(AssetDispatch assetDispatch)
    {
        this.assetDispatch = assetDispatch;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<AssetDispatch> getAssetDispatchList()
    {
        return assetDispatchList;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public boolean isIsAuction()
    {
        return isAuction;
    }

    public void setIsAuction(boolean isAuction)
    {
        this.isAuction = isAuction;
    }
    
}
