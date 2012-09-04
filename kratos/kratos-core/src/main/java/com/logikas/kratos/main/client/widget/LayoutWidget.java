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
import com.google.gwt.user.client.Window;
import com.logikas.kratos.main.client.resource.MainResourceBundle;
import javax.inject.Inject;

/**
 *
 * @author csrinaldi
 */
public class LayoutWidget implements LayoutView {

    private final int MENU_WITH = 100;
    private final int MENU_MARGIN = 5;
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
    @UiField
    MainResourceBundle res;
    private static MainResourceBundle DEFAULT_RESOURCES;

    private static MainResourceBundle getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES =
                    GWT.create(MainResourceBundle.class);

        }
        return DEFAULT_RESOURCES;
    }
    private LayoutPanel root;
    private PlaceController controller;

    @Inject
    public LayoutWidget(PlaceController controller) {
        getDefaultResources().layoutStyle().ensureInjected();
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
        /*
         * return new AcceptsOneWidget() {
         *
         * @Override public void setWidget(IsWidget w) { Widget widget =
         * Widget.asWidgetOrNull(w); west.setWidget(widget); }
        };
         */
        GWT.log("getWestRegion");
        return west;
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

        root.setWidgetLeftWidth(west, 0, PCT, MENU_WITH, Style.Unit.PX);
        root.setWidgetTopHeight(west, 0, PCT, 100, PCT);

        root.setWidgetLeftWidth(center, MENU_WITH + MENU_MARGIN, Style.Unit.PX, (Window.getClientWidth() - (MENU_WITH + MENU_MARGIN)), Style.Unit.PX);
        root.setWidgetTopHeight(center, 0, Style.Unit.PX, 100, PCT);

        root.setWidgetLeftWidth(south, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(south, 0, PCT, 0, PCT);

        root.setWidgetLeftWidth(east, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(east, 0, PCT, 0, PCT);

        root.animate(500);
    }
}
