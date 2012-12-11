/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.ioc.jpa;

import java.util.Set;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface DynamicPersist
 *
 *
 * Package: com.logikas.kratos.core.ioc.jpa 
 * Last modification: 28/11/2012
 * File: DynamicPersist.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface DynamicPersist {
    
    void reloadClasses(Set<Class<?>> classes);

}
