/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.helth.humanresources.business.ioc;

import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceFilter;
import com.logikas.kratos.core.module.event.EventDispatcher;
import com.logikas.kratos.helth.humanresources.business.BusinessModule;
import com.logikas.kratos.helth.humanresources.business.server.BusinessServlet;
import com.logikas.kratos.helth.humanresources.business.service.PersonService;
import com.logikas.kratos.helth.humanresources.business.service.PersonServiceImpl;
import org.apache.felix.http.api.ExtHttpService;
import org.ops4j.peaberry.activation.util.PeaberryActivationModule;
import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;



/**
 *
 * @author cristian
 */
public class ActivationModule extends PeaberryActivationModule {

    
    @Override
    protected void configure() {
        
        bind(export(BusinessModule.class)).toProvider(service(BusinessModule.class).export());
        bind(BusinessModule.class).in(Singleton.class);
        
        //bind(BusinessServlet.class).in(Singleton.class);
        
        bind(PersonService.class).to(PersonServiceImpl.class);
       
        bind(EventDispatcher.class).toProvider(service(EventDispatcher.class).single());
        //bind(GuiceFilter.class).toProvider(service(GuiceFilter.class).single());
        
        //bind(ExtHttpService.class).toProvider(service(ExtHttpService.class).single());
        
        install(new BusinessServletModule());
        
        requestInjection(this);
        
        
    }
}
