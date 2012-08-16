/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.security.service;

/**
 * Realiza la autenticacion real contra el datastore correspondiente
 * 
 * 
 */
public interface SecurityService {
    
    //TODO Podemos ver como encapsular esto en una Clase Credentials
    void login(String username, String password);
    
}
