/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.module.event;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface EventDispatcher
 *
 *
 * Package: com.logikas.kratos.core.module.event 
 * Last modification: 20/11/2012
 * File: EventDispatcher.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface EventDispatcher {

    void post(Object object);
    
    void register(Object object);
    
    void unregister(Object object);
    
}
