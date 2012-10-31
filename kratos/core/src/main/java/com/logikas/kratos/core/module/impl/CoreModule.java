/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.module.impl;

import com.logikas.kratos.core.Module;

/**
 *
 * @author cristian
 */

public class CoreModule implements Module{

    public String getName() {
        return this.getClass().getCanonicalName();
    }
    
}
