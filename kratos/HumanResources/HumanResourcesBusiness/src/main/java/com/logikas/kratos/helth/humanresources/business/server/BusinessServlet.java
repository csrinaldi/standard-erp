/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.business.server;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.logikas.kratos.helth.humanresources.business.service.PersonProxy;
import com.logikas.kratos.helth.humanresources.business.service.PersonService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Human Resources Business OSGi Bundle
 *
 * Documentation of Class BusinessServlet
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.business.server 
 * Last modification: 01/12/2012
 * File: BusinessServlet.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
@Singleton
public class BusinessServlet extends HttpServlet{
    
    private final PersonService service;

    
    @Inject
    public BusinessServlet(PersonService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PersonProxy proxy = service.findById(new Long(10));
        
        resp.getWriter().print(proxy.toString());
    }
    
}
