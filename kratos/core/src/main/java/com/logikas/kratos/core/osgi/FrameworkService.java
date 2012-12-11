/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.osgi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import javax.servlet.ServletContext;
import org.apache.felix.framework.util.FelixConstants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class FrameworkService
 *
 *
 * Package: com.logikas.kratos.core.osgi Last modification: 04/12/2012 File:
 * FrameworkService.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class FrameworkService {

    private ServletContext context;

    public FrameworkService(ServletContext context) {
        this.context = context;
    }

    public void start() {
        try {
            doStart();
        } catch (Exception e) {
            log("Failed to start framework", e);
        }
    }

    public void stop() {
        try {
            doStop();
        } catch (Exception e) {
            log("Error stopping framework", e);
        }
    }

    private void doStart()
            throws Exception {

        FrameworkFactory frameworkFactory = ServiceLoader.load(
                FrameworkFactory.class).iterator().next();
        Map<String, Object> config = createConfig();
// TODO: add some config properties
        Framework framework = frameworkFactory.newFramework(config);
        framework.start();



        /*Felix tmp = new Felix(createConfig());
         tmp.start();
         this.felix = tmp;
         log("OSGi framework started", null);*/
    }

    private void doStop()
            throws Exception {
       /* if (this.felix != null) {
            this.felix.stop();
        }*/

        log("OSGi framework stopped", null);
    }

    private Map<String, Object> createConfig()
            throws Exception {
        Properties props = new Properties();
        props.load(this.context.getResourceAsStream("/WEB-INF/framework.properties"));

        HashMap<String, Object> map = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            map.put(key.toString(), props.get(key));
        }

        //map.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(new CoreActivator(this.context)));
        return map;
    }

    private void log(String message, Throwable cause) {
        this.context.log(message, cause);
    }
}
