/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.services;

import com.khoders.ams.app.entities.Asset;
import com.khoders.ams.app.entities.AssetCategory;
import com.khoders.ams.app.entities.Auction;
import com.khoders.ams.app.entities.AssetLocation;
import com.khoders.ams.app.entities.Client;
import com.khoders.ams.app.entities.Complaint;
import com.khoders.ams.app.entities.CubicleAllocation;
import com.khoders.ams.app.entities.DamagedAsset;
import com.khoders.ams.app.entities.Department;
import com.khoders.ams.app.entities.Faculty;
import com.khoders.ams.app.entities.Inspection;
import com.khoders.ams.app.entities.Vendor;
import com.khoders.ams.app.listener.AppSession;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.DateRangeUtil;
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
    
    public List<Auction> getAuctionList()
    {
        String queryString = "SELECT e FROM Auction e WHERE e.userAccount=?1";
        return crudApi.getEm().createQuery(queryString, Auction.class)
                .setParameter(1, appSession.getCurrentUser())
                .getResultList();
    }
    
    public List<CubicleAllocation> getCubicleAllocationList()
    {
        String queryString = "SELECT e FROM CubicleAllocation e WHERE e.userAccount=?1";
        return crudApi.getEm().createQuery(queryString, CubicleAllocation.class)
                .setParameter(1, appSession.getCurrentUser())
                .getResultList();
    }
    
    public List<Vendor> getVendorList()
    {
        String queryString = "SELECT e FROM Vendor e WHERE e.userAccount=?1";
        return crudApi.getEm().createQuery(queryString, Vendor.class)
                .setParameter(1, appSession.getCurrentUser())
                .getResultList();
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
    
    public List<Inspection> getInspectionList()
    {
        try
        {
            String queryString = "SELECT e FROM Inspection e WHERE e.userAccount=?1";
            TypedQuery<Inspection> typedQuery = crudApi.getEm().createQuery(queryString, Inspection.class)
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
    public List<DamagedAsset> getDamagedAssetList()
    {
        try
        {
            String queryString = "SELECT e FROM DamagedAsset e WHERE e.userAccount=?1";
            TypedQuery<DamagedAsset> typedQuery = crudApi.getEm().createQuery(queryString, DamagedAsset.class)
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
    public List<Department> getDepartmentListByFaculty(Faculty selectedFaculty)
    {
        try
        {
            String queryString = "SELECT e FROM Department e WHERE e.faculty=?1 AND e.userAccount=?2";
            TypedQuery<Department> typedQuery = crudApi.getEm().createQuery(queryString, Department.class)
                    .setParameter(1, selectedFaculty)
                    .setParameter(2, appSession.getCurrentUser());
            
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
    
    public List<Complaint> getComplaints(DateRangeUtil dateRange)
    {
        try {
            if(dateRange.getFromDate() == null || dateRange.getToDate() == null)
            {
                  String  queryString = "SELECT e FROM Complaint e WHERE e.userAccount=?1 ORDER BY e.valueDate DESC";
                  TypedQuery<Complaint> typedQuery = crudApi.getEm().createQuery(queryString, Complaint.class)
                                              .setParameter(1, appSession.getCurrentUser());
                                    return typedQuery.getResultList();
            }
            
            String qryString = "SELECT e FROM Complaint e WHERE e.valueDate BETWEEN ?1 AND ?2 AND e.userAccount=?3 ORDER BY e.valueDate DESC";
            
            TypedQuery<Complaint> typedQuery = crudApi.getEm().createQuery(qryString, Complaint.class)
                    .setParameter(1, dateRange.getFromDate())
                    .setParameter(2, dateRange.getToDate())
                    .setParameter(3, appSession.getCurrentUser());
           return typedQuery.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<Asset> getAssets(DateRangeUtil dateRange)
    {
        try {
            if(dateRange.getFromDate() == null || dateRange.getToDate() == null)
            {
                  String  queryString = "SELECT e FROM Asset e WHERE e.userAccount=?1 ORDER BY e.regDate DESC";
                  TypedQuery<Asset> typedQuery = crudApi.getEm().createQuery(queryString, Asset.class)
                                              .setParameter(1, appSession.getCurrentUser());
                                    return typedQuery.getResultList();
            }
            
            String qryString = "SELECT e FROM Asset e WHERE e.regDate BETWEEN ?1 AND ?2 AND e.userAccount=?3 ORDER BY e.valueDate DESC";
            
            TypedQuery<Asset> typedQuery = crudApi.getEm().createQuery(qryString, Asset.class)
                    .setParameter(1, dateRange.getFromDate())
                    .setParameter(2, dateRange.getToDate())
                    .setParameter(3, appSession.getCurrentUser());
           return typedQuery.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
