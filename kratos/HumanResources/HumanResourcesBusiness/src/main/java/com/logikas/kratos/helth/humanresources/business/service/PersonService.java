/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.helth.humanresources.business.service;

/**
 * Human Resources Business OSGi Bundle
 *
 * Documentation of Interface PersonService
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.business.service 
 * Last modification: 01/12/2012
 * File: PersonService.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface PersonService {

    PersonProxy findById(Long id);
    
}
