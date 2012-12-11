/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.persistence.api;

import com.logikas.kratos.core.module.Module;
import java.util.Set;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface PersistenceModule
 *
 *
 * Package: com.logikas.kratos.core.persistence.api 
 * Last modification: 22/11/2012
 * File: PersistenceModule.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface PersistenceModule extends Module{
    
    Set<Class<?>> getPersistentClasses();
    
}
