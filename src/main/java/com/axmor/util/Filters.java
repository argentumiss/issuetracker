/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axmor.util;

import spark.*;

/**
 *
 * @author Alice
 */
public class Filters {
    // If a user manually manipulates paths and forgets to add
    // a trailing slash, redirect the user to the correct path
    public static Filter addTrailingSlashes = (Request request, Response response) -> {
        if (!request.pathInfo().endsWith("/")) {
            response.redirect(request.pathInfo() + "/");
        }
    };

    // Locale change can be initiated from any page
    // The locale is extracted from the request and saved to the user's session
    public static Filter handleLocaleChange = (Request request, Response response) -> {
        if (RequestUtil.getQueryLocale(request) != null) {
            request.session().attribute("locale", RequestUtil.getQueryLocale(request));
            response.redirect(request.pathInfo());
        }
    };

    // Enable GZIP for all responses
    public static Filter addGzipHeader = (Request request, Response response) -> {
        response.header("Content-Encoding", "gzip");
    };
}
