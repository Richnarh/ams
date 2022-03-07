/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ams.app.entities;

import com.khoders.ams.app.entities.enums.ComplainStatus;
import java.io.Serializable;
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
 * @author richa
 */
@Entity
@Table(name = "complainant")
public class Complaint extends UserAccountRecord implements Serializable
{
    @Column(name = "complain_title")
    private String complainTitle;
    
    @Column(name = "complaint_name")
    private String complaintName;
    
    @Column(name = "officer_name")
    private String officerName;
    
    @Column(name = "officer_phone")
    private String officerPhone;
    
    @JoinColumn(name = "faculty", referencedColumnName = "id")
    @ManyToOne
    private Faculty faculty;
    
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne
    private Department department;
    
    @Column(name = "complain_status")
    @Enumerated(EnumType.STRING)
    private ComplainStatus complainStatus;
    
    @Lob
    @Column(name = "message")
    private String message;

    public String getComplainTitle()
    {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle)
    {
        this.complainTitle = complainTitle;
    }

    public String getComplaintName()
    {
        return complaintName;
    }

    public void setComplaintName(String complaintName)
    {
        this.complaintName = complaintName;
    }

    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty = faculty;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public ComplainStatus getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(ComplainStatus complainStatus) {
        this.complainStatus = complainStatus;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerPhone() {
        return officerPhone;
    }

    public void setOfficerPhone(String officerPhone) {
        this.officerPhone = officerPhone;
    }

    
}
