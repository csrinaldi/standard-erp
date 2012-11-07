/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.commons.repository;

import java.io.Serializable;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Interface Repository
 *
 *
 *
 * Package: com.logikas.kratos.core.ioc
 *
 * Last modification: 06/11/2012 File:Repository.java
 *
 * @author Cristian Rinaldi 
 * cristian.rinaldi@logikas.com 
 * Logikas - Conectando Ideas.
 */
public interface Repository<T, ID extends Serializable> {

    T find(ID id);

    T save(T entity);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);
}
