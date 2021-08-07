/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities.enums;

import com.khoders.resource.utilities.MsgResolver;

/**
 *
 * @author richa
 */
public enum AssetStatus implements MsgResolver
{
    NEW("NEW", "New"),
    OLD("OLD", "Old"),
    USED("USED", "Used"),
    DAMAGED("DAMAGED", "Damaged");
    
    private final String label;
    private final String code;
    
    private AssetStatus(String code, String label)
    {
      this.code=code;
      this.label = label;
    }

    @Override
    public String getCode()
    {
       return code;
    }

    @Override
    public String getLabel()
    {
       return label;
    }
    
}
