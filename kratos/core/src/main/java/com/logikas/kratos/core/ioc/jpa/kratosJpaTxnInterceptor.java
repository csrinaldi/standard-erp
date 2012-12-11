/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.ioc.jpa;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class kratosJpaTxnInterceptor
 *
 *
 * Package: com.logikas.kratos.core.ioc.jpa 
 * Last modification: 29/11/2012
 * File: kratosJpaTxnInterceptor.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */

public class kratosJpaTxnInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
