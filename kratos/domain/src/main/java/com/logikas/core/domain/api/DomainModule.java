/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.core.domain.api;

import com.logikas.kratos.core.module.Module;

/**
 * Kratos Domain OSGi Bundle
 *
 * Documentation of Class DomainModule
 *
 *
 * Package: com.logikas.core.domain.api 
 * Last modification: 05/11/2012
 * File: DomainModule.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class DomainModule implements Module{

    public String getName() {
        return this.getClass().getName();
    }

    public Boolean initialize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean isActive() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean shutdown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
