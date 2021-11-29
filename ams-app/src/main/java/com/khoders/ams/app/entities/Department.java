/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "department")
public class Department extends UserAccountRecord implements Serializable
{
   @Column(name = "dept_code")
   private String deptCode;
   
   @Column(name = "dept_name")
   private String deptName;
   
   @JoinColumn(name = "faculty", referencedColumnName = "id")
   @ManyToOne
   private Faculty faculty;

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
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
       return deptName;
    }
   
}
