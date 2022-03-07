/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.commons;

import com.khoders.ams.app.entities.enums.AssetStatus;
import com.khoders.ams.app.entities.enums.ComplainStatus;
import com.khoders.ams.app.entities.enums.DispatchType;
import com.khoders.resource.enums.ClientType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "commonBeans")
@SessionScoped
public class CommonBeans implements Serializable
{
    public List<AssetStatus> getAssetStatus()
    {
        return Arrays.asList(AssetStatus.values());
    }
    public List<ClientType> getClientTypeList()
    {
        return Arrays.asList(ClientType.values());
    }
    public List<DispatchType> getDispatchTypeList()
    {
        return Arrays.asList(DispatchType.values());
    }
    public List<ComplainStatus> getComplainStatusList()
    {
        return Arrays.asList(ComplainStatus.values());
    }
}
