/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.module.event;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface EventHandler
 *
 *
 * Package: com.logikas.kratos.core.module.event 
 * Last modification: 05/11/2012
 * File: EventHandler.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface EventHandler<T> {
    
    void handle(T event);

}
