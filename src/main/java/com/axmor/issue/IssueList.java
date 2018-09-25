/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.issue;

import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public class IssueList {
    private ArrayList<Issue> issues; 
            
    public IssueList() {
        issues = new ArrayList<>();
        issues.add(new Issue("1", "perwendel", "issue1", "first", "2018-01-01", "created"));
        issues.add(new Issue("2", "davidase", "issue2", "second", "2018-01-02", "resolved"));
        issues.add(new Issue("3", "federico", "issue3", "third", "2018-01-03", "closed"));
    }

    public Issue getIssueById(String issueId){
        return issues.stream().filter(b->b.getIssueId().equals(issueId)).findFirst().orElse(null);
    }
    
    public ArrayList<Issue> getAllIssues() {
        return issues;
    }
}
