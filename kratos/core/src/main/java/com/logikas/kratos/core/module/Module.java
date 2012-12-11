package com.logikas.kratos.core.module;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface Module
 *
 *
 * Package: com.logikas.kratos.core.module 
 * Last modification: 05/11/2012 
 * File: Module.java
 *
 * @author Cristian Rinaldi 
 * cristian.rinaldi@logikas.com 
 * Logikas - Conectando Ideas.
 *
 */
public interface Module {

    String getName();
    
    Boolean initialize();
    
    Boolean isActive();
    
    Boolean shutdown();
    
    void setName(String name);
}
