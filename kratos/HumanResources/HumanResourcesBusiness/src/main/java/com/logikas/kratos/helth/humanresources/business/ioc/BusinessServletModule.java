/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.business.ioc;

import com.google.inject.servlet.ServletModule;
import com.logikas.kratos.helth.humanresources.business.server.BusinessServlet;

/**
 * Human Resources Business OSGi Bundle
 *
 * Documentation of Class ServletModule
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.business.ioc 
 * Last modification: 01/12/2012
 * File: ServletModule.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class BusinessServletModule extends ServletModule{

    @Override
    protected void configureServlets() {
        serve("/person").with(BusinessServlet.class);
    }
}
