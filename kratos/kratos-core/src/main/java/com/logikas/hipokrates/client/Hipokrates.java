/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.logikas.hipokrates.client.ioc.HipokratesGinjector;

/**
 *
 * @author cristian
 */
public class Hipokrates implements EntryPoint{

    public void onModuleLoad() {
        HipokratesGinjector injector = GWT.create(HipokratesGinjector.class);
        injector.getDistribution().start();
    }
    
    
    
}
