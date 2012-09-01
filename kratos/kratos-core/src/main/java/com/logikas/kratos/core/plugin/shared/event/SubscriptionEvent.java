/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 *
 * @author cristian
 */
public class SubscriptionEvent extends GwtEvent<SubscriptionHandler> {

    private static Type<SubscriptionHandler> TYPE = null;

    private final ModuleInfo moduleInfo;
    
    public static void fire(HasSubscriptionHandlers source, ModuleInfo info){
        source.fireEvent(new SubscriptionEvent(info));
    }
    
    protected SubscriptionEvent(ModuleInfo moduleInfo){
        this.moduleInfo = moduleInfo;
    }
    
    @Override
    public Type<SubscriptionHandler> getAssociatedType() {
        return getType();
    }

    @Override
    protected void dispatch(SubscriptionHandler handler) {
        handler.onSubscription(this);
    }
    
    public static Type<SubscriptionHandler> getType(){
        if ( TYPE == null ){
            TYPE = new Type<SubscriptionHandler>();
        }
        return TYPE;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }
    
    
    
}
