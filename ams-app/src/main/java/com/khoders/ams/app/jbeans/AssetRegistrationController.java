/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.AssetRegistration;
import com.khoders.ams.app.services.AssetService;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
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
 * @author richa
 */
@Named(value = "assetRegistrationController")
@SessionScoped
public class AssetRegistrationController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    
    private AssetRegistration assetRegistration = new AssetRegistration();
    private List<AssetRegistration> assetRegistrationList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       assetRegistrationList = assetService.getRegisteredAssetList();
    }
    
    public void saveAssetRegistration()
    {
        try
        {
            if(crudApi.save(assetRegistration) != null)
            {
                assetRegistrationList = CollectionList.washList(assetRegistrationList, assetRegistration);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               closePage();
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
    
    public void editAssetRegistration(AssetRegistration assetRegistration)
    {
       this.assetRegistration = assetRegistration;
       optionText = "Update";
    }
    
    public void deleleteAssetRegistration(AssetRegistration assetRegistration)
    {
        try
        {
           if(crudApi.delete(assetRegistration))
           {
               assetRegistrationList.remove(assetRegistration);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void closePage()
    {
       assetRegistration = new AssetRegistration();
       optionText = "Save Changes";
       pageView.restToListView();
    }

    public AssetRegistration getAssetRegistration()
    {
        return assetRegistration;
    }

    public void setAssetRegistration(AssetRegistration assetRegistration)
    {
        this.assetRegistration = assetRegistration;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<AssetRegistration> getAssetRegistrationList()
    {
        return assetRegistrationList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
