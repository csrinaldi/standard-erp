/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author cristian
 */
public class GuiceFactory {

    private static final Injector inj = Guice.createInjector();

    public static Injector getInjector() {
        return inj;
    }
}
