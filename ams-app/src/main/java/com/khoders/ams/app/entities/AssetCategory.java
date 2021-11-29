/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "asset_category")
public class AssetCategory extends UserAccountRecord implements Serializable
{
    @Column(name = "category_name")
    private String categoryName;

    public String getCategoryName()
    {
        return categoryName; 
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    
    @Override
    public String toString()
    {
       return categoryName;
    }
}
