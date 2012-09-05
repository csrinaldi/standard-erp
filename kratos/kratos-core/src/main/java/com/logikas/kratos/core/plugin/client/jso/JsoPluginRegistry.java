/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 *
 * @author cristian
 */
class JsoPluginRegistry extends JavaScriptObject {

    public static interface Handler {

        void onSubscribe(JsoPluginDescription info);
    }

    protected JsoPluginRegistry() {
    }

    protected native final JsArray<JavaScriptObject> getHandlers() /*-{
     return this.handlers;
     }-*/;

    protected native final PluginDescription getPlugin(String name) /*-{
     return this.plugins[name] || null;
     }-*/;

    protected native final void addPlugin(String name, PluginDescription info) /*-{
     this.plugins[name] = info;
     }-*/;

    private static native void callHandler(JavaScriptObject handler, PluginDescription info) /*-{
     handler(info);    
     }-*/;

    private static native JavaScriptObject createHandlerFunction(Handler handler) /*-{
     return function(info){
     handler.@com.logikas.kratos.core.plugin.client.jso.JsoPluginRegistry.Handler::onSubscribe(Lcom/logikas/kratos/core/plugin/client/jso/JsoPluginDescription;)(info);
     };
     }-*/;

    public native static JsoPluginRegistry get(String name)/*-{
     return $wnd[name] || ($wnd[name] = {plugins: {}, handlers: []});
     }-*/;

    public final boolean subscribe(PluginDescription info) {
        final PluginDescription exists = getPlugin(info.getName());
        if (exists != null) {
            return false;
        }
        addPlugin(info.getName(), info);
        for (int i = 0, top = getHandlers().length(); i < top; i++) {
            callHandler(getHandlers().get(i), info);
        }
        return true;
    }

    public final int addHandler(Handler handler) {
        final int id = getHandlers().length();
        getHandlers().push(createHandlerFunction(handler));
        return id;
    }

    public final void removeHandler(int n) {
        getHandlers().set(n, null);
    }
;
}
