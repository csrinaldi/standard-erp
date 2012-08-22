/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 *
 * @author cristian
 */
public class JsoModuleInfo extends JavaScriptObject implements ModuleInfo{

    @Override
    public MenuNode getMenuNode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
