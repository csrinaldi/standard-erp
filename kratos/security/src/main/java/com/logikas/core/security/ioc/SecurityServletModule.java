/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.core.security.ioc;

import com.google.inject.servlet.ServletModule;
import com.logikas.core.security.server.SecurityServlet;

/**
 * Kratos Security OSGi Bundle
 *
 * Documentation of Class SecurityServletModule
 *
 *
 * Package: com.logikas.core.security.ioc 
 * Last modification: 30/11/2012
 * File: SecurityServletModule.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class SecurityServletModule extends ServletModule{

    @Override
    protected void configureServlets() {
        serve("/security").with(SecurityServlet.class);
        
    }
    
     

}
