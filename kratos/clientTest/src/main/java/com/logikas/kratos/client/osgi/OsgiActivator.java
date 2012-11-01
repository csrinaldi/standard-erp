/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author cristian
 */
public class OsgiActivator implements BundleActivator{

    @Override
    public void start(BundleContext bc) throws Exception {
        System.out.print("Bundle Activated");
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        
    }
    
}
