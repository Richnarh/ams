/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "inspection")
public class Inspection extends UserAccountRecord implements Serializable
{
  @Column(name = "area_name")
  private String areaName;
  
  @Column(name = "inspection_date")
  private LocalDate inspectionDate;
  
  @Column(name = "report")
  @Lob
  private String report;

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public LocalDate getInspectionDate()
    {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate)
    {
        this.inspectionDate = inspectionDate;
    }

    public String getReport()
    {
        return report;
    }

    public void setReport(String report)
    {
        this.report = report;
    }
  
}
