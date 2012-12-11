/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.core.security.service;

import com.logikas.core.security.persistence.User;

/**
 * Kratos Security OSGi Bundle
 *
 * Documentation of Interface UserService
 *
 *
 * Package: com.logikas.core.security.service 
 * Last modification: 30/11/2012
 * File: UserService.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface UserService {

    User findById(Long id);
    
}
