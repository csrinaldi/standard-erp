/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.osgi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceFilter;
import com.logikas.kratos.core.ioc.ActivationModule;
import com.logikas.kratos.core.ioc.CoreServletModule;
import com.logikas.kratos.core.module.impl.CoreModule;
import java.util.ArrayList;
import java.util.Hashtable;
import org.ops4j.peaberry.Peaberry;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class CoreActivator
 *
 *
 * Package: com.logikas.kratos.core.osgi Last modification: 21/11/2012 File:
 * CoreActivator.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class CoreActivator implements BundleActivator {

    @Override
    public void start(final BundleContext bc) throws Exception {

        System.out.println("Starting CoreActivator ....");

        ArrayList<Module> modules = new ArrayList<Module>();

        modules.add(Peaberry.osgiModule(bc));
        modules.add(new ActivationModule());
        modules.add(new CoreServletModule());
        //modules.add(new KratosPersistModule("kratos"));

        /*Bundle[] bundles = bc.getBundles();
         for (Bundle b : bundles) {
         Dictionary<String, String> d = b.getHeaders();
         if (d != null) {
         String fragmentHost = d.get("Fragment-Host");
         if (fragmentHost != null && fragmentHost.equals("com.logikas.kratos.core")) {
         String moduleName = d.get("Kratos-Module");
         if (moduleName != null) {
         Class<? extends Module> moduleClass = bc.getBundle().loadClass(moduleName);
         modules.add(moduleClass.newInstance());
         }
         }
         }
         }*/

        /*ServiceReference srf = bc.getServiceReference(GuiceFilter.class.getName());
         Object gf = bc.getService(srf);
         if ( gf != null ){
         System.out.println("El servicio ya estaba registrado");
         bc.ungetService(srf);
         }else{
         System.out.println("El servicio no estaba registrado");
         }*/



        Injector inj;
        inj = Guice.createInjector(modules);

        GuiceFilter filter = inj.getInstance(GuiceFilter.class);
        //PersistFilter persistFilter = inj.getInstance(PersistFilter.class);

        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("pattern", ".*");
        bc.registerService(GuiceFilter.class.getName(), filter, props);

        //inj.injectMembers(this);

        CoreModule module = inj.getInstance(CoreModule.class);
        module.initialize();

        bc.addBundleListener(module);

        System.out.println("CoreActivator Started ...... OK\n");



    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        System.out.println("CoreActivator Stoped");

        //guiceFilter.unput();

    }
}
