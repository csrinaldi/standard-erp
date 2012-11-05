/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.osgi;

import com.logikas.kratos.core.module.Module;
import java.util.Map;
import org.ops4j.peaberry.Import;
import org.ops4j.peaberry.util.AbstractWatcher;

/**
 *
 * @author Cristian Rinaldi - Logikas Conectando Ideas
 * csrinaldi@gmail.com
 */
public class Watcher extends AbstractWatcher<Module> {
    
    @Override
    protected Module adding(Import<Module> service) {
        System.out.print("\n"+service.get().getName() + "is ADD\n");
        return super.adding(service);
    }

    @Override
    protected void removed(Module instance) {
        System.out.println("\n"+instance.getName() + "is REMOVED\n");
        super.removed(instance);
    }

    @Override
    protected void modified(Module instance, Map<String, ?> attributes) {
        System.out.print("\n"+instance.getName()+ "is ADD\n");
        super.modified(instance, attributes);
    }
    
    
}
