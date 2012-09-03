/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.hipokrates.client.ioc;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import com.logikas.kratos.core.plugin.shared.Distribution;

/**
 * 
 * @author cristian
 */
@GinModules({HipokratesModule.class})
public interface HipokratesGinjector extends Ginjector {

  Distribution getDistribution();
}
