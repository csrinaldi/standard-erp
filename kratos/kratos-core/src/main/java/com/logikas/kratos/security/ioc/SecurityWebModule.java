/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.security.ioc;

import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;

/**
 * 
 * @author csrinaldi
 */
public class SecurityWebModule extends ShiroWebModule {

  public SecurityWebModule(ServletContext servletContext) {
    super(servletContext);
  }

  @Override
  protected void configureShiroWeb() {

    //bindRealm().toConstructor(null);
    
  }

}
