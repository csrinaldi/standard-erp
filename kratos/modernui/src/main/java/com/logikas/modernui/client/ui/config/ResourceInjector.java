/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.modernui.client.ui.config;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.logikas.modernui.client.ui.resources.Resources;

/**
 * ModernUi
 *
 * Documentation of Class ResourceInjector
 *
 *
 * Package: com.logikas.modernui.client.ui.config 
 * Last modification: 19/12/2012
 * File: ResourceInjector.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class ResourceInjector {
    
    private static final Resources resources = GWT.create(Resources.class);
    
    public static void configure(){
        
        StyleInjector.inject(resources.bootmetroCss().getText(), true);
        
        StyleInjector.inject(resources.bootmetroResponsiveCss().getText(), true);
        
        StyleInjector.inject(resources.bootmetroIconsCss().getText(), true);
        
        StyleInjector.inject(resources.bootmetroLightCss().getText(), true);
        
        
    }
}
