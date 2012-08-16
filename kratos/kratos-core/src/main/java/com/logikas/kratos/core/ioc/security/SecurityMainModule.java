/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.security;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;

/**
 *
 * @author csrinaldi
 */
public class SecurityMainModule extends AbstractModule {

    ServletContext context = null;
    
    public SecurityMainModule(ServletContext context) {
        this.context = context;
    }

    /**
     * Crea de manera programática el SecurityManager
     * //TODO ver la carga de Reamls
     * @return 
     */
    @Provides
    @Singleton
    SecurityManager getSecurityManager(){
        SecurityManager manager = new DefaultSecurityManager();
        return manager;
    }

    @Override
    protected void configure() {
        SecurityModule module = new SecurityModule();
        SecurityWebModule webModule = new SecurityWebModule(context);
        SecurityAOPModule aopModule = new SecurityAOPModule();
        
        install(module);
        install(webModule);
        install(aopModule);
        
    }
    
    
}
