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
@Table(name = "faculty")
public class Faculty extends UserAccountRecord implements Serializable
{
    @Column(name = "faculty_code")
    private String facultyCode;
    
    @Column(name = "faculty_name")
    private String facultyname;

    public String getFacultyCode()
    {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode)
    {
        this.facultyCode = facultyCode;
    }

    public String getFacultyname()
    {
        return facultyname;
    }

    public void setFacultyname(String facultyname)
    {
        this.facultyname = facultyname;
    }

    @Override
    public String toString()
    {
       return facultyname;
    }
    
}
