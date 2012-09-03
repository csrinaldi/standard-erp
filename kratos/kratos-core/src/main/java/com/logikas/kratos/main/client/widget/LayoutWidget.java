/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.widget;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.logikas.kratos.main.client.view.LayoutView;
import static com.google.gwt.dom.client.Style.Unit.PCT;
import javax.inject.Inject;

/**
 *
 * @author csrinaldi
 */
public class LayoutWidget implements LayoutView {

    private static LayoutWidgetUiBinder uiBinder = GWT.create(LayoutWidgetUiBinder.class);

    interface LayoutWidgetUiBinder extends UiBinder<LayoutPanel, LayoutWidget> {
    }
    @UiField
    SimplePanel west;
    @UiField
    ScrollPanel center;
    @UiField
    SimplePanel south;
    @UiField
    SimplePanel east;

    /*
     * @UiField ClientResource res;
     *
     * private static ClientResource DEFAULT_RESOURCES;
     *
     * private static ClientResource getDefaultResources() { if
     * (DEFAULT_RESOURCES == null) { DEFAULT_RESOURCES =
     * GWT.create(ClientResource.class);
     *
     * } return DEFAULT_RESOURCES; }
     */
    private final LayoutPanel root;
    private PlaceController controller;

    @Inject
    public LayoutWidget(PlaceController controller) {
        // getDefaultResources().erpLgkStyle().ensureInjected();
        root = uiBinder.createAndBindUi(this);

        this.controller = controller;
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

    @Override
    public AcceptsOneWidget getSouthRegion() {
        return new AcceptsOneWidget() {

            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                south.setWidget(widget);
            }
        };
    }

    @Override
    public void setDefaultLayout() {
        
        GWT.log("setDefaultLayout");
        
        root.setWidgetLeftWidth(west, 0, PCT, 50, Style.Unit.PX);
        root.setWidgetTopHeight(west, 0, PCT, 100, PCT);
        
        root.setWidgetTopHeight(center, 0, PCT, 0, PCT);
        root.setWidgetLeftWidth(center, 0, Style.Unit.PX, 0, PCT);
        
        root.setWidgetLeftWidth(south, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(south, 0, PCT, 0, PCT);
        
        root.setWidgetLeftWidth(east, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(east, 0, PCT, 0, PCT);
        
        root.animate(500);
        
    }
}
