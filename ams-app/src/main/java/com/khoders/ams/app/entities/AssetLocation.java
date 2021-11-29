package com.khoders.ams.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author 
 */
@Entity
@Table(name = "asset_location")
public class AssetLocation extends UserAccountRecord implements Serializable
{
    @Column(name = "location_code")
    private String locationCode;
    
    @Column(name = "location_name")
    private String locationName;

    public String getLocationCode()
    {
        return locationCode;
    }

    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }
    
    
}
