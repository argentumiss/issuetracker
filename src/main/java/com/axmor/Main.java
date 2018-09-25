package com.axmor;


import com.axmor.issue.IssueList;
import com.axmor.issue.IssueController;
import com.axmor.login.LoginController;
import com.axmor.util.ViewUtil;
import com.axmor.util.Filters;
import com.axmor.util.Path;
import com.axmor.user.UserList;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;


/**
 * Application entry point
 */
public class Main {

    // Declare dependencies
    public static IssueList issueList;
    public static UserList userList;

    public static void main(String[] args) {

        // Instantiate your dependencies
        issueList = new IssueList();
        userList = new UserList();

        //Configure spark
        port(80);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);

        // Set up before-filters (called before each get/post)
        before("*", Filters.addTrailingSlashes);
        before("*", Filters.handleLocaleChange);
        // Set up routes
//        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.ISSUES, IssueController.fetchAllIssues);
        get(Path.Web.ONE_ISSUE, IssueController.fetchOneIssue);
        get(Path.Web.LOGIN, LoginController.serveLoginPage);
        post(Path.Web.LOGIN, LoginController.handleLoginPost);
        post(Path.Web.LOGOUT, LoginController.handleLogoutPost);
        get("*", ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*", Filters.addGzipHeader);
    }
}
