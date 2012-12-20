/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.modernui.client.ui;

import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.logikas.modernui.client.ui.constant.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * ModernUi
 *
 * Documentation of Class Hub
 *
 *
 * Package: com.logikas.modernui.client.ui Last modification: 19/12/2012 File:
 * Hub.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class Hub extends FluidContainer {
    

    public Hub() {
        setStylePrimaryName(Constants.METRO);
    }
    
    public void setSpan(String span){
        addStyleName("span"+span);
    }
}
