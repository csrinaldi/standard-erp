/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.logikas.kratos.core.plugin.client.jso.JsoModuleInfo;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 *
 * @author cristian
 */
class JsoModuleRegistry extends JavaScriptObject {
    
    public static interface Handler{
        void onSubscribe(JsoModuleInfo info);
    }

    protected JsoModuleRegistry(){
        
    }
    
    
    public native static JsoModuleRegistry get()/*-{
     return $wnd.ModuleRegistry;
     }-*/;

    public native final boolean subscribe(ModuleInfo info)/*-{
     return this.subscribe(info); 
     }-*/;

    public native final int addHandler(Handler handler)/*-{
     return this.addHandler(function(info){ 
       handler.@com.logikas.kratos.core.plugin.client.JsoModuleRegistry.Handler::onSubscribe(Lcom/logikas/kratos/core/plugin/client/jso/JsoModuleInfo;)(info);}); 
     }-*/;

    public native final void removeHandler(int n)/*-{
     this.removeHandler(n); 
     }-*/;
}
