/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Human Resource Domain OSGi Bundle
 *
 * Documentation of Interface Dao
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.dao 
 * Last modification: 01/12/2012
 * File: Dao.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface Repository<T extends Serializable, C> {
    
    C finById(T type);
    
    List<C> findAll();

}
