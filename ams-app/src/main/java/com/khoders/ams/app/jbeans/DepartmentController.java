/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.Department;
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
@Named(value = "departmentController")
@SessionScoped
public class DepartmentController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private Department department = new Department();
    private List<Department> departmentList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       departmentList = assetService.getDepartmentList();
       clearDepartment();
    }
    
    public void saveDepartment()
    {
        try
        {
            department.genCode();
            if(crudApi.save(department) != null)
            {
                departmentList = CollectionList.washList(departmentList, department);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearDepartment();
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
    
    public void editDepartment(Department department)
    {
       this.department = department;
       optionText = "Update";
    }
    
    public void deleteDepartment(Department department)
    {
        try
        {
           if(crudApi.delete(department))
           {
               departmentList.remove(department);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearDepartment()
    {
       department = new Department();
       department.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
