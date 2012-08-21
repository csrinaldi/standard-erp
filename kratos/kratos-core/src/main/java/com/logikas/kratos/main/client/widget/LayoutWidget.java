/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.widget;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.main.client.view.LayoutView;

/**
 *
 * @author csrinaldi
 */
public class LayoutWidget implements LayoutView{

    private static LayoutWidgetUiBinder uiBinder = GWT.create(LayoutWidgetUiBinder.class);

    interface LayoutWidgetUiBinder extends UiBinder<LayoutPanel, LayoutWidget> {
    }

    @UiField
    ScrollPanel west;
   
    @UiField
    ScrollPanel center;

    /*@UiField
    ClientResource res;

    private static ClientResource DEFAULT_RESOURCES;

    private static ClientResource getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(ClientResource.class);

        }
        return DEFAULT_RESOURCES;
    }*/

    private final LayoutPanel root;

    public LayoutWidget() {
        //getDefaultResources().erpLgkStyle().ensureInjected();
        root = uiBinder.createAndBindUi(this);
    }
    
    @Override
    public Widget asWidget() {
        return root;
    }

    @Override
    public AcceptsOneWidget getCenterRegion() {
        return new AcceptsOneWidget() {

            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                center.setWidget(widget);
            }

        };
    }
    
    @Override
    public AcceptsOneWidget getWestRegion() {
        return new AcceptsOneWidget() {

            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                west.setWidget(widget);
            }

        };
    }

    
}
