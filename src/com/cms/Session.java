/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 *
 * this class will hold all the global variable related to authentication and
 * authorization
 *
 * @author Mallika
 */
public class Session implements Serializable {

    private int userId;
    private Timestamp entryTime;
    private int companyID;
    private String financialYearFrom;
    private String userRole;
    private List<String> companyDetailList;

    public List<String> getCompanyDetailList() {
        return companyDetailList;
    }

    public void setCompanyDetailList(List<String> companyDetailList) {
        this.companyDetailList = companyDetailList;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public void setFinancialYearFrom(String FinancialYearFrom) {
        this.financialYearFrom = FinancialYearFrom;
    }

    public String getFinancialYearFrom() {
        return financialYearFrom;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
