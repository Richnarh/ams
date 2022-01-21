/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.ReportFiles;
import com.khoders.ams.app.entities.DamagedAsset;
import com.khoders.ams.app.jbeans.reportModels.AssetRegModel;
import com.khoders.ams.app.jbeans.reportModels.DamagedAssetModel;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.ams.app.services.AssetService;
import com.khoders.ams.app.services.XtractService;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.reports.ReportManager;
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
@Named(value = "damagedAssetController")
@SessionScoped
public class DamagedAssetController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private XtractService xtractService;
    @Inject private ReportManager reportManager;
    @Inject private AppSession appSession;
    
    private DamagedAsset damagedAsset = new DamagedAsset();
    private List<DamagedAsset> damagedAssetList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       damagedAssetList = assetService.getDamagedAssetList();
       clearDamagedAsset();
    }
    
    public void saveDamagedAsset()
    {
        try
        {
            damagedAsset.genCode();
            if(crudApi.save(damagedAsset) != null)
            {
                damagedAssetList = CollectionList.washList(damagedAssetList, damagedAsset);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearDamagedAsset();
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
    
    public void editDamagedAsset(DamagedAsset damagedAsset)
    {
       this.damagedAsset = damagedAsset;
       optionText = "Update";
    }
    
    public void deleteDamagedAsset(DamagedAsset damagedAsset)
    {
        try
        {
           if(crudApi.delete(damagedAsset))
           {
               damagedAssetList.remove(damagedAsset);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void printDamagedAsset(){
        damagedAssetList = assetService.getDamagedAssetList();
        List<DamagedAssetModel> damagedAssetModelList = new LinkedList<>();
        
        if(!damagedAssetList.isEmpty())
        {
            DamagedAssetModel model = xtractService.extractToDamagedAsset(damagedAssetList, new DamagedAssetModel());
            damagedAssetModelList.add(model);
        }
        reportManager.createReport(damagedAssetModelList, ReportFiles.DAMAGED_ASSET_REPORT);
    }
    
    public void clearDamagedAsset()
    {
       damagedAsset = new DamagedAsset();
       damagedAsset.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public DamagedAsset getDamagedAsset()
    {
        return damagedAsset;
    }

    public void setDamagedAsset(DamagedAsset damagedAsset)
    {
        this.damagedAsset = damagedAsset;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<DamagedAsset> getDamagedAssetList()
    {
        return damagedAssetList;
    }

    public String getOptionText()
    {
        return optionText;
    }

}
