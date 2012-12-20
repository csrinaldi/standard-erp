/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.modernui.client.ui;

import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.modernui.client.ui.constant.Constants;

/**
 * ModernUi
 *
 * Documentation of Class PanoramaSection
 *
 *
 * Package: com.logikas.modernui.client.ui 
 * Last modification: 19/12/2012
 * File: PanoramaSection.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class PanoramaSection extends FluidContainer{
    
    private String title;

    public PanoramaSection() {
        setStylePrimaryName(Constants.PANORAMA_SECTION);
    }
    
    @Override
    public void add(IsWidget w){
        if ( w instanceof Tile ){
            super.add(w);
        }
    }
    
    @Override
    public void add(Widget w){
        if ( w instanceof Tile ){
            super.add(w);
        }
    }
}
        