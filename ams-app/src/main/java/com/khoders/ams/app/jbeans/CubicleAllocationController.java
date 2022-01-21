/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.CubicleAllocation;
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
@Named(value = "cubicleAllocationController")
@SessionScoped
public class CubicleAllocationController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private CubicleAllocation cubicleAllocation = new CubicleAllocation();
    private List<CubicleAllocation> cubicleAllocationList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       cubicleAllocationList = assetService.getCubicleAllocationList();
       clearCubicleAllocation();
    }
    
    public void saveCubicleAllocation()
    {
        try
        {
            cubicleAllocation.genCode();
            if(crudApi.save(cubicleAllocation) != null)
            {
                cubicleAllocationList = CollectionList.washList(cubicleAllocationList, cubicleAllocation);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearCubicleAllocation();
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
    
    public void editCubicleAllocation(CubicleAllocation cubicleAllocation)
    {
       this.cubicleAllocation = cubicleAllocation;
       optionText = "Update";
    }
    
    public void deleteCubicleAllocation(CubicleAllocation cubicleAllocation)
    {
        try
        {
           if(crudApi.delete(cubicleAllocation))
           {
               cubicleAllocationList.remove(cubicleAllocation);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearCubicleAllocation()
    {
       cubicleAllocation = new CubicleAllocation();
       cubicleAllocation.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public CubicleAllocation getCubicleAllocation()
    {
        return cubicleAllocation;
    }

    public void setCubicleAllocation(CubicleAllocation cubicleAllocation)
    {
        this.cubicleAllocation = cubicleAllocation;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<CubicleAllocation> getCubicleAllocationList()
    {
        return cubicleAllocationList;
    }

    public String getOptionText()
    {
        return optionText;
    }

}
