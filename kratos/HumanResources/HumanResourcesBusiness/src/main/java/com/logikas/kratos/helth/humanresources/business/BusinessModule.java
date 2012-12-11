/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.helth.humanresources.business;

import com.google.inject.Injector;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.helth.humanresources.business.server.BusinessServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import org.apache.felix.http.api.ExtHttpService;
import org.ops4j.peaberry.activation.Start;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

/**
 * Human Resources Business OSGi Bundle
 *
 * Documentation of Class BusinessModule
 *
 *
 * Package: com.logikas.kratos.helth.humanresources.business Last modification:
 * 01/12/2012 File: BusinessModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */


public class BusinessModule implements Module {


    @Override
    public String getName() {
        return "Human Resource Module";
    }

    @Override
    @Start
    public Boolean initialize() {
        return true;
    }

    @Override
    public Boolean isActive() {
        return true;
    }

    @Override
    public Boolean shutdown() {
        return true;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
