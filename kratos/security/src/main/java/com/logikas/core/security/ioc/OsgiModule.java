/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.core.security.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.logikas.core.security.service.UserService;
import com.logikas.core.security.service.impl.UserServiceImpl;

/**
 * 
 * 
 * @author Cristian Rinaldi - Logikas Contectando Ideas
 * @version 1.0-SNAPSHOT
 */
public class OsgiModule extends AbstractModule{

    @Override
    protected void configure() {
        
        install(new SecurityServletModule());
        
        bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
    }
    
}
