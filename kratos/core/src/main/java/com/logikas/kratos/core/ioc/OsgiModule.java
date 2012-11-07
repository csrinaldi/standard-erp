/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc;

import com.google.inject.AbstractModule;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.impl.CoreModule;
import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

/**
 *
 * @author cristian
 * @deprecated @see AcrivationModule
 */

@Deprecated
public class OsgiModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(export(Module.class)).toProvider(service(CoreModule.class).export());
       
    }
    
}
