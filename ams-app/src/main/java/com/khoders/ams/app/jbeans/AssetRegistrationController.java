/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.ReportFiles;
import com.khoders.ams.app.entities.AssetRegistration;
import com.khoders.ams.app.jbeans.reportModels.AssetRegModel;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.ams.app.services.AssetService;
import com.khoders.ams.app.services.XtractService;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.reports.ReportManager;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.DateRangeUtil;
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
 * @author khoders
 */
@Named(value = "assetRegistrationController")
@SessionScoped
public class AssetRegistrationController implements Serializable
{
    @Inject
    private CrudApi crudApi;
    @Inject
    private AppSession appSession;
    @Inject private AssetService assetService;
    @Inject private XtractService xtractService;
    @Inject private ReportManager reportManager;
    
    private AssetRegistration assetRegistration = new AssetRegistration();
    private List<AssetRegistration> assetRegistrationList = new LinkedList<>();
    private DateRangeUtil dateRange = new DateRangeUtil();

    private FormView pageView = FormView.listForm();
    private String optionText;

    @PostConstruct
    private void init()
    {
       assetRegistrationList = assetService.getRegisteredAssetList();
    }

    public void initAsset()
    {
        clearAssetRegistration();
        pageView.restToCreateView();
    }
    
    public void filterAsset(){
        assetRegistrationList = assetService.getAssetRegistration(dateRange); 
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
    
    public void deleteAssetRegistration(AssetRegistration assetRegistration)
    {
        try
        {
            if (crudApi.delete(assetRegistration))
            {
                assetRegistrationList.remove(assetRegistration);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null));
            } else
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, Msg.FAILED_MESSAGE, null));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void printAssetRegistration(){
         assetRegistrationList = assetService.getAssetRegistration(dateRange); 
        List<AssetRegModel> assetModelList = new LinkedList<>();
        
        if(!assetRegistrationList.isEmpty())
        {
            AssetRegModel assetModel = xtractService.extractToAssetReg(assetRegistrationList, new AssetRegModel());
            assetModelList.add(assetModel);
        }
        reportManager.createReport(assetModelList, ReportFiles.ASSET_REG_REPORT);
    }

    public void editAssetRegistration(AssetRegistration assetRegistration)
    {
        pageView.restToCreateView();
        this.assetRegistration = assetRegistration;
        optionText = "Update";
    }
    
    public void clearAssetRegistration()
    {
        assetRegistration = new AssetRegistration();
        assetRegistration.genCode();
        assetRegistration.setUserAccount(appSession.getCurrentUser());
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public void closePage()
    {
        assetRegistration = new AssetRegistration();
        assetRegistration.genCode();
        assetRegistration.setUserAccount(appSession.getCurrentUser());
        optionText = "Save Changes";
        pageView.restToListView();
    }

    public String getOptionText()
    {
        return optionText;
    }

    public void setOptionText(String optionText)
    {
        this.optionText = optionText;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }
    
    public DateRangeUtil getDateRange()
    {
        return dateRange;
    }

    public void setDateRange(DateRangeUtil dateRange)
    {
        this.dateRange = dateRange;
    }

    public List<AssetRegistration> getAssetRegistrationList()
    {
        return assetRegistrationList;
    }

    public AssetRegistration getAssetRegistration()
    {
        return assetRegistration;
    }

    public void setAssetRegistration(AssetRegistration assetRegistration)
    {
        this.assetRegistration = assetRegistration;
    }
    
}
