/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.security;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.apache.shiro.guice.web.ShiroWebModule;

/**
 *
 * @author csrinaldi
 */
public class SecurityWebModule extends ShiroWebModule{

    public SecurityWebModule(ServletContext servletContext) {
        super(servletContext);
    }
    
    @Override
    protected void configureShiroWeb() {
        //bindRealm().toConstructor(null)
    }
    
}
