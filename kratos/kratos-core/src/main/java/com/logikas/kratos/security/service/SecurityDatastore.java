/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.security.service;

/**
 *
 * @author csrinaldi
 */
public interface SecurityDatastore {
    
    void login( SecurityToken token );

}
