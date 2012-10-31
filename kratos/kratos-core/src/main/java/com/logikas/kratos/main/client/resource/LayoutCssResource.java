/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.main.client.resource;

import com.google.gwt.resources.client.CssResource;

/**
 * 
 * @author Cristian Rinaldi  cristian.rinaldi@logikas.com
 * @version
 * @date 03/09/2012
 * Logikas - Conectacto Ideas 
 */
public interface LayoutCssResource extends CssResource{
    
    String DEFAULT_CSS = "com/logikas/kratos/main/client/resource/layoutCssResource.css";

    @ClassName("north-panel")
    String northPanel();
    
    @ClassName("side-menu")
    String sideMenu();

    @ClassName("background-center")
    String backgroundCenter();
    
    @ClassName("menu-module")
    String menuModule();
}
