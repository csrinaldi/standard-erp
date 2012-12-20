/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.modernui.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.logikas.modernui.client.ui.constant.Constants;

/**
 * ModernUi
 *
 * Documentation of Class TileApp
 *
 *
 * Package: com.logikas.modernui.client.ui 
 * Last modification: 19/12/2012
 * File: TileApp.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class TileApp extends Tile{
    
    public DivElement label = Document.get().createDivElement();
    public DivElement count = Document.get().createDivElement();

    public TileApp() {
        super();
        addStyleName(Constants.TILE_APP);
        
        label.addClassName(Constants.APP_LABEL);
        count.addClassName(Constants.APP_COUNT);
        getElement().appendChild(label);
        getElement().appendChild(count);
    }
    
    public void setLabel(String name){
        this.label.setInnerHTML(name);
    }

    public void setCount(String count){
        this.count.setInnerHTML(count);
    }
}
