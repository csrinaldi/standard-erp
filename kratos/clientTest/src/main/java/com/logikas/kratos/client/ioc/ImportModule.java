/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.google.inject.AbstractModule;
import com.logikas.kratos.core.module.Module;
import static org.ops4j.peaberry.Peaberry.service;

/**
 *
 * @author cristian
 */
public class ImportModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(Module.class).toProvider(service(Module.class).single());
    }
    
}
