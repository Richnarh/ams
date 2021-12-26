/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.Complaint;
import com.khoders.ams.app.entities.Department;
import com.khoders.ams.app.entities.Faculty;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.ams.app.services.AssetService;
import com.khoders.resource.jpa.CrudApi;
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
@Named(value = "compliantController")
@SessionScoped
public class ComplaintController implements Serializable
{

    @Inject
    private CrudApi crudApi;
    @Inject
    private AppSession appSession;
    @Inject private AssetService assetService;
    private Complaint compliant = new Complaint();
    private List<Complaint> compliantList = new LinkedList<>();
    
    private List<Department> departmentList = new LinkedList<>();
    
    private DateRangeUtil dateRange = new DateRangeUtil();

    private FormView pageView = FormView.listForm();
    private String optionText;

    @PostConstruct
    private void init()
    {
        clearComplaint();
        compliantList = assetService.getComplaintList();
    }

    public void initComplaint()
    {
        clearComplaint();
        pageView.restToCreateView();
    }
    
    public void fetchDepartment()
    {
        Faculty selectedFaculty = compliant.getFaculty();
        departmentList = assetService.getDepartmentListByFaculty(selectedFaculty);
    }
    
    public void filterComplaint()
    {
      compliantList = assetService.getComplaints(dateRange); 
    }
        
    public void saveComplaint()
    {
        
        try
        {
            
            if (crudApi.save(compliant) != null)
            {
               compliantList = CollectionList.washList(compliantList, compliant);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null));
            } else
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, Msg.FAILED_MESSAGE, null));
            }
            clearComplaint();
            closePage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteComplaint(Complaint compliant)
    {
        try
        {
            if (crudApi.delete(compliant))
            {
                compliantList.remove(compliant);

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

    public void editComplaint(Complaint compliant)
    {
        pageView.restToCreateView();
        this.compliant = compliant;
        optionText = "Update";
    }

    public void clearComplaint()
    {
        compliant = new Complaint();
        departmentList = new LinkedList<>();
        compliant.setUserAccount(appSession.getCurrentUser());
        compliant.genCode();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public void closePage()
    {
        compliant = new Complaint();
        optionText = "Save Changes";
        pageView.restToListView();
    }

    public List<Complaint> getComplaintList()
    {
        return compliantList;
    }

    public Complaint getCompliant()
    {
        return compliant;
    }

    public void setCompliant(Complaint compliant)
    {
        this.compliant = compliant;
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

    public List<Complaint> getCompliantList()
    {
        return compliantList;
    }

    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public DateRangeUtil getDateRange()
    {
        return dateRange;
    }

    public void setDateRange(DateRangeUtil dateRange)
    {
        this.dateRange = dateRange;
    }

}
