/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.core.security.service.impl;

import com.logikas.core.security.persistence.User;
import com.logikas.core.security.service.UserService;

/**
 * Kratos Security OSGi Bundle
 *
 * Documentation of Class UserServiceImpl
 *
 *
 * Package: com.logikas.core.security.service.impl 
 * Last modification: 30/11/2012
 * File: UserServiceImpl.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class UserServiceImpl implements UserService{

    @Override
    public User findById(Long id) {
        
        User u = new User();
        u.setId(new Long(12));
        
        return u;
        
    }

}
