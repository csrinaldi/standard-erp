/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.modernui.client.ui;

import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.github.gwtbootstrap.client.ui.FluidRow;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.modernui.client.ui.constant.Constants;

/**
 * ModernUi
 *
 * Documentation of Class Panorama
 *
 *
 * Package: com.logikas.modernui.client.ui Last modification: 19/12/2012 File:
 * Panorama.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class Panorama extends DivWidget {

    private FluidRow sections;

    public Panorama() {
        setStylePrimaryName(Constants.PANORAMA);
        sections = new FluidRow();
        sections.addStyleName(Constants.PANORAMA_SECTIONS);
        super.add(sections);
    }

    @Override
    public void add(IsWidget w) {
        if (w instanceof PanoramaSection) {
            sections.add(w);
        }
    }

    @Override
    public void add(Widget w) {
        if (w instanceof PanoramaSection) {
            sections.add(w);
        }
    }
}
