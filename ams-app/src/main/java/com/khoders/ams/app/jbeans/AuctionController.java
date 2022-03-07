/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.jbeans;

import com.khoders.ams.app.entities.Auction;
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
@Named(value = "auctionController")
@SessionScoped
public class AuctionController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AssetService assetService;
    @Inject private AppSession appSession;
    
    private Auction auction = new Auction();
    private List<Auction> auctionList = new LinkedList<>();
    
    FormView pageView = FormView.listForm();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       auctionList = assetService.getAuctionList();
       clearAssetDispatch();
    }
    
    public void saveAssetDispatch()
    {
        try
        {
            auction.genCode();
            if(crudApi.save(auction) != null)
            {
                auctionList = CollectionList.washList(auctionList, auction);
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
    
    public void editAssetDispatch(Auction auction)
    {
       this.auction = auction;
       optionText = "Update";
    }
    
    public void deleteAssetDispatch(Auction auction)
    {
        try
        {
           if(crudApi.delete(auction))
           {
               auctionList.remove(auction);
               
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
       auction = new Auction();
       auction.setUserAccount(appSession.getCurrentUser());
       optionText = "Save Changes";
       SystemUtils.resetJsfUI();
    }

    public Auction getAuction()
    {
        return auction;
    }

    public void setAuction(Auction auction)
    {
        this.auction = auction;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public List<Auction> getAuctionList()
    {
        return auctionList;
    }

    public String getOptionText()
    {
        return optionText;
    }

}
