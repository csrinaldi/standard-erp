/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.core.security.ioc;

import com.google.inject.AbstractModule;
import com.logikas.core.security.module.SecurityModule;
import com.logikas.kratos.core.module.Module;
import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

/**
 * 
 * 
 * @author Cristian Rinaldi - Logikas Contectando Ideas
 * @version 1.0-SNAPSHOT
 */
public class OsgiModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(export(Module.class)).toProvider(service(SecurityModule.class).export());
    }
    
}
