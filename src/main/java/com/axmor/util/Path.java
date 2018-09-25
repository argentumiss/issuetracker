/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.util;

/**
 *
 * @author Alice
 */
public class Path {
    public static class Web {
        public static final String INDEX = "/index/";
        public static final String LOGIN = "/login/";
        public static final String LOGOUT = "/logout/";
        public static final String ISSUES = "/issues/";
        public static final String ONE_ISSUE = "/issues/:issueId/";
        
        public static String getINDEX() {
            return INDEX;
        }
        
        public static String getLOGIN() {
            return LOGIN;
        }
        
        public static String getLOGOUT() {
            return LOGOUT;
        }
        
        public static String getISSUES() {
            return ISSUES;
        }
        
        public static String getONE_ISSUE() {
            return ONE_ISSUE;
        }
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String ISSUE_ALL = "/velocity/issue/all.vm";
        public static final String ISSUE_ONE = "/velocity/issue/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
        
        public static String getINDEX() {
            return INDEX;
        }
        
        public static String getLOGIN() {
            return LOGIN;
        }
        
        public static String getNOT_FOUND() {
            return NOT_FOUND;
        }
        
        public static String getISSUE_ALL() {
            return ISSUE_ALL;
        }
        
        public static String getISSUE_ONE() {
            return ISSUE_ONE;
        }
    }
}
