package com.khoders.ams.app.entities;

import com.khoders.ams.app.entities.enums.AssetStatus;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author 
 */
@Entity
@Table(name = "asset")
public class Asset extends UserAccountRecord implements Serializable
{
    @Column(name = "asset_code")
    private String assetCode;
    
    @Column(name = "reg_date")
    private LocalDate regDate;
    
    @JoinColumn(name = "asset_location", referencedColumnName = "id")
    @ManyToOne
    private AssetLocation assetLocation;
    
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne
    private Department department;
    
    @JoinColumn(name = "faculty", referencedColumnName = "id")
    @ManyToOne
    private Faculty faculty;
    
    @Column(name = "asset_status")
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;
    
    @Column(name = "asset_name")
    private String assetName;
        
    @Column(name = "expected_lifespan")
    private String expectedLifeSpan;
    
    @JoinColumn(name = "asset_category", referencedColumnName = "id")
    @ManyToOne
    private AssetCategory assetCategory;

    @Column(name = "description")
    @Lob
    private String description;
        
    public String getAssetName()
    {
        return assetName;
    }

    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }

    public String getExpectedLifeSpan()
    {
        return expectedLifeSpan;
    }

    public void setExpectedLifeSpan(String expectedLifeSpan)
    {
        this.expectedLifeSpan = expectedLifeSpan;
    }
    
    public AssetCategory getAssetCategory()
    {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory)
    {
        this.assetCategory = assetCategory;
    }

    public String getAssetCode()
    {
        return assetCode;
    }

    public void setAssetCode(String assetCode)
    {
        this.assetCode = assetCode;
    }

    public LocalDate getRegDate()
    {
        return regDate;
    }

    public void setRegDate(LocalDate regDate)
    {
        this.regDate = regDate;
    }
    
    public AssetLocation getAssetLocation()
    {
        return assetLocation;
    }

    public void setAssetLocation(AssetLocation assetLocation)
    {
        this.assetLocation = assetLocation;
    }

    public AssetStatus getAssetStatus()
    {
        return assetStatus;
    }

    public void setAssetStatus(AssetStatus assetStatus)
    {
        this.assetStatus = assetStatus;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty = faculty;
    }
   
    @Override
    public String toString()
    {
       return assetName;
    }
    
}
