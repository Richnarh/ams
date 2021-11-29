/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.services;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.AssetCategory;
import com.khoders.ams.app.entities.AssetLocation;
import com.khoders.ams.app.entities.AssetRegistration;
import com.khoders.ams.app.entities.Client;
import com.khoders.ams.app.entities.Complaint;
import com.khoders.ams.app.entities.Department;
import com.khoders.ams.app.entities.Faculty;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.resource.jpa.CrudApi;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author richa
 */
@Stateless
public class AssetService
{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    
    public List<Asset> getAssetList()
    {
        String queryString = "SELECT e FROM Asset e WHERE e.userAccount=?1";
        return crudApi.getEm().createQuery(queryString, Asset.class)
                .setParameter(1, appSession.getCurrentUser())
                .getResultList();
    }
    
    public List<AssetRegistration> getRegisteredAssetList()
    {
        try
        {
            String queryString = "SELECT e FROM AssetRegistration e WHERE e.userAccount=?1";
            TypedQuery<AssetRegistration> typedQuery = crudApi.getEm().createQuery(queryString, AssetRegistration.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public List<AssetCategory> getAssetCategoryList()
    {
        try
        {
            String queryString = "SELECT e FROM AssetCategory e WHERE e.userAccount=?1";
            TypedQuery<AssetCategory> typedQuery = crudApi.getEm().createQuery(queryString, AssetCategory.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public List<AssetLocation> getAssetLocationList()
    {
        try
        {
            String queryString = "SELECT e FROM AssetLocation e WHERE e.userAccount=?1";
            TypedQuery<AssetLocation> typedQuery = crudApi.getEm().createQuery(queryString, AssetLocation.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Faculty> getFacultyList()
    {
        try
        {
            String queryString = "SELECT e FROM Faculty e WHERE e.userAccount=?1";
            TypedQuery<Faculty> typedQuery = crudApi.getEm().createQuery(queryString, Faculty.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Department> getDepartmentList()
    {
        try
        {
            String queryString = "SELECT e FROM Department e WHERE e.userAccount=?1";
            TypedQuery<Department> typedQuery = crudApi.getEm().createQuery(queryString, Department.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Client> getClientList()
    {
        try
        {
            String queryString = "SELECT e FROM Client e WHERE e.userAccount=?1";
            TypedQuery<Client> typedQuery = crudApi.getEm().createQuery(queryString, Client.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Complaint> getComplaintList()
    {
        try
        {
            String queryString = "SELECT e FROM Complaint e WHERE e.userAccount=?1";
            TypedQuery<Complaint> typedQuery = crudApi.getEm().createQuery(queryString, Complaint.class)
                    .setParameter(1, appSession.getCurrentUser());
            
                   return typedQuery.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public Client clientExist(String phone)
    {
        try
        {
            String qryString = "SELECT e FROM Client e WHERE e.phone=?1";
            TypedQuery<Client> typedQuery = crudApi.getEm().createQuery(qryString, Client.class)
                    .setParameter(1, phone);
            
                    return typedQuery.getResultStream().findFirst().orElse(null);
                    
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
