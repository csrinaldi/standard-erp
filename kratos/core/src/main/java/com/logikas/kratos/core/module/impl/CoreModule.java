package com.logikas.kratos.core.module.impl;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import com.logikas.kratos.core.ioc.jpa.DynamicPersist;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.EventDispatcher;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Dictionary;
import java.util.Set;
import org.ops4j.peaberry.activation.Start;
import org.ops4j.peaberry.activation.Stop;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;

/**
 *
 *
 * kratos Core OSGI Bundle
 *
 * Documentation of Class CoreModule
 *
 * Este representa al Core. Es el encargado de inicializar y detener el modulo
 *
 *
 *
 * Package: com.logikas.kratos.core.module.impl Last modification: 06/11/2012
 * File: CoreModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class CoreModule implements Module, BundleListener {

    String name;
    private Boolean active;
    private EventDispatcher bus;
    private Set<Class<?>> classes;
    /*private final DynamicPersist dynamicService;
    private final PersistService persistService;*/

    @Inject
    public CoreModule(EventDispatcher dispatcher) {
        Date date = new Date();
        this.name = "PEPE " + new Timestamp(date.getTime());
        this.bus = dispatcher;
        /*this.dynamicService = dynamicService;
        this.persistService = persistService;*/
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    @Start
    public Boolean initialize() {
        this.active = true;
        this.bus.register(this);

       /* if (this.persistService != null) {
            System.out.println("Persistence Service is AVAILABLE");
            this.persistService.start();
        } else {
            System.out.println("Persistence Service is NOT AVAILABLE");
        }*/

        return this.active;
    }

    @Override
    public Boolean isActive() {
        return this.active;
    }

    @Override
    @Stop
    public Boolean shutdown() {
        this.active = false;
        this.bus.unregister(this);
        return this.active;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Subscribe
    public void listen(ModuleInitializedEvent e) {
        System.out.print(" Listener >>>> " + e.getClass().getClassLoader());
    }

    @Override
    public void bundleChanged(BundleEvent be) {

        if (be.getType() == BundleEvent.INSTALLED) {
            Bundle bnd = be.getBundle();
            Dictionary<String, String> d = bnd.getHeaders();
            String fragment = d.get("Fragment-Host");
            if ( fragment != null && fragment.equals("com.logikas.kratos.core")) {
                try {
                    be.getBundle().update();
                } catch (BundleException ex) {
                    System.out.println("No se puede hacer el UPDATE!!!!!!!!");
                }
            }
        }

        /*System.out.println(" Listener >>>> " + be.getBundle().getSymbolicName() + "  " + be.getType());

        BundleContext bc = be.getBundle().getBundleContext();

        if (be.getType() == BundleEvent.STARTED || be.getType() == BundleEvent.INSTALLED) {

            ServiceReference[] srs = be.getBundle().getRegisteredServices();

            if (srs != null) {
                int i = 0;
                while (i < srs.length) {
                    Object o = bc.getService(srs[i]);
                    if (o instanceof PersistenceModule) {
                        Set<Class<?>> classes = ((PersistenceModule) o).getPersistentClasses();
                        Iterator<Class<?>> it = classes.iterator();
                        while (it.hasNext()) {

                            Class<? extends Object> class1 = it.next();



                            //Thread.currentThread().getContextClassLoader().loadClass(class1.getCanonicalName());
                            System.out.println("Persistence CLASS " + class1.getCanonicalName() + " IS LOADED");

                        }
                        dynamicService.reloadClasses(classes);

                    }
                    i++;
                }
            }
        }*/
    }
}
