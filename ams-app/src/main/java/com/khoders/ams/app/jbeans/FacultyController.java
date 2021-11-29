/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.Faculty;
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
@Named(value = "facultyController")
@SessionScoped
public class FacultyController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private Faculty faculty = new Faculty();
    private List<Faculty> facultyList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       facultyList = assetService.getFacultyList();
       clearFaculty();
    }
    
    public void saveFaculty()
    {
        try
        {
            faculty.genCode();
            if(crudApi.save(faculty) != null)
            {
                facultyList = CollectionList.washList(facultyList, faculty);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.setMsg("Purchase order saved"), null)); 
               
               clearFaculty();
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
    
    public void editFaculty(Faculty faculty)
    {
       this.faculty = faculty;
       optionText = "Update";
    }
    
    public void deleteFaculty(Faculty faculty)
    {
        try
        {
           if(crudApi.delete(faculty))
           {
               facultyList.remove(faculty);
               
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, Msg.SUCCESS_MESSAGE, null)); 
               
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearFaculty()
    {
       faculty = new Faculty();
       faculty.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }
    
    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty = faculty;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<Faculty> getFacultyList()
    {
        return facultyList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
