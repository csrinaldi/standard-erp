/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.core.security.server;

import com.logikas.core.security.persistence.User;
import com.logikas.core.security.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Kratos Security OSGi Bundle
 *
 * Documentation of Class SecurityServlet
 *
 *
 * Package: com.logikas.core.security.server 
 * Last modification: 30/11/2012
 * File: SecurityServlet.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
@Singleton
public class SecurityServlet extends HttpServlet{

    private final UserService userService;
    
    @Inject
    public SecurityServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        User user = userService.findById(new Long(1));
        
        resp.getWriter().print("El usuario es "+user.getId());
    }
    
    

}
