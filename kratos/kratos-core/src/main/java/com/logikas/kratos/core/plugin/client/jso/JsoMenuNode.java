package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.model.MenuNode;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * 
 * //TODO podriamos ver de hacerlo con Elemental asi no trabajamos con 
 * JSNI
 */
class JsoMenuNode extends JavaScriptObject implements MenuNode {

    native static final JsoMenuNode create() /*-{
     return {};
     }-*/;

    protected JsoMenuNode() {
    }

    @Override
    public native final String getToken() /*-{
     return this.token || null;
     }-*/;

    native final void setToken(String token) /*-{
     this.token = token;
     }-*/;

    @Override
    public native final String getIcon() /*-{
     return this.icon;
     }-*/;

    native final void setIcon(String icon) /*-{
     this.icon = icon;
     }-*/;

    @Override
    public native final String getTitle() /*-{
     return this.action || null;
     }-*/;

    native final void setTitle(String title) /*-{
     this.title = title;
     }-*/;

    native final void addChild(String name, JsoMenuNode child) /*-{
     this.children[name] = child;
     }-*/;

    @Override
    public native final String getTooltip() /*-{
     return this.tooltip || null;
     }-*/;

    native final void setTooltip(String tooltip) /*-{
     this.tooltip = tooltip;
     }-*/;

    @Override
    public native final int getPriority() /*-{
     return this.priority || 0;
     }-*/;

    native final void setPriority(int priority) /*-{
     this.priority = priority;
     }-*/;

    @Override
    public native final void visitChildren(Visitor visitor) /*-{
     if(this.children) {
     var name, children = this.children;
     for (name in children) {
     visitor.@com.logikas.kratos.core.plugin.shared.model.MenuNode.Visitor::onChild(Lcom/logikas/kratos/core/plugin/shared/model/MenuNode;)(children[name]);
     }
     }
     }-*/;
}
