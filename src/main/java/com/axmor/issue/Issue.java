/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.issue;

/**
 *
 * @author Alice
 */
public class Issue {
    String issueId;
    String user;
    String title;
    String description;
    String date;
    String status;
    
    public Issue(String iId, String usr, String ttl, String desc, String dd, String stat) {
        issueId = iId;
        user = usr;
        title = ttl;
        description = desc;
        date = dd;
        status = stat;
    }
    
    public String getIssueId() {
        return issueId;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getStatus() {
        return status;
    }
}
