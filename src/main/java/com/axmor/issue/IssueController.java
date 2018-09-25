/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.issue;

import com.axmor.login.LoginController;
import com.axmor.util.RequestUtil;
import com.axmor.util.ViewUtil;
import com.axmor.util.Path;
import com.axmor.user.User;
import static com.axmor.util.JsonUtil.dataToJson;
import static com.axmor.Main.issueList;
import static com.axmor.Main.userList;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Alice
 */
public class IssueController {
    public static Route fetchAllIssues = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (RequestUtil.clientAcceptsHtml(request)) {
            Map<String, Object> model = new HashMap<>();
            model.put("issues", issueList.getAllIssues());
            return ViewUtil.render(request, model, Path.Template.ISSUE_ALL);
        }
        if (RequestUtil.clientAcceptsJson(request)) {
            return dataToJson(issueList.getAllIssues());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
    public static Route fetchOneIssue = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (RequestUtil.clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Issue issue = issueList.getIssueById(RequestUtil.getParamIssueId(request));
            if (issue != null) {
            User user = userList.getUserByUsername(issue.getUser());
            model.put("issue", issue);
            model.put("user", user);

            return ViewUtil.render(request, model, Path.Template.ISSUE_ONE);
            }
            else {
                return ViewUtil.render(request, model, Path.Template.NOT_FOUND);
            }
        }
        if (RequestUtil.clientAcceptsJson(request)) {
            return dataToJson(issueList.getIssueById(RequestUtil.getParamIssueId(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
