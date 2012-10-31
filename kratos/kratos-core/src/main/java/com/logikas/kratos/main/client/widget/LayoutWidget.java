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
import com.logikas.kratos.core.ui.client.LayoutView;
import static com.google.gwt.dom.client.Style.Unit.PCT;
import com.google.gwt.user.client.Window;
import com.logikas.kratos.main.client.resource.MainResourceBundle;
import javax.inject.Inject;

/**
 *
 * @author Cristian Rinaldi
 */
public class LayoutWidget implements LayoutView {

    /**
     * Representa el ancho de la region oeste de la pantalla
     */
    private final int MENU_WITH = 100;
    /**
     * Representa el margen entre la region oeste y la region central
     */
    private final int MENU_MARGIN = 5;
    /**
     * Representa el alto de la region del norte de la pantalla
     */
    private final int NORTH_HEIGHT = 80;
    
    /**
     * Representa el alto del menu de modulos
     */
    private final int MENU_MODULE_HEIGHT = 50;
    
    private static LayoutWidgetUiBinder uiBinder = GWT.create(LayoutWidgetUiBinder.class);

    interface LayoutWidgetUiBinder extends UiBinder<LayoutPanel, LayoutWidget> {
    }
    @UiField
    SimplePanel north;
    @UiField
    SimplePanel west;
    @UiField
    ScrollPanel center;
    @UiField
    SimplePanel south;
    @UiField
    SimplePanel east;
    @UiField
    SimplePanel menuModule;
    
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
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget =
                        Widget.asWidgetOrNull(w);
                west.setWidget(widget);
            }
        };
    }

    @Override
    public AcceptsOneWidget getNorthRegion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget =
                        Widget.asWidgetOrNull(w);
                north.setWidget(widget);
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
    public AcceptsOneWidget getMenuModuleRegion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                menuModule.setWidget(widget);
            }
        };
    }

    @Override
    public void setDefaultLayout() {
        
        final int padding = 5;
        
        root.setWidgetLeftWidth(north, 0, Style.Unit.PX, Window.getClientWidth(), Style.Unit.PX);
        root.setWidgetTopHeight(north, 0, Style.Unit.PX, NORTH_HEIGHT, Style.Unit.PX);

        root.setWidgetLeftWidth(menuModule, MENU_WITH + MENU_MARGIN + padding, 
                                Style.Unit.PX, 
                                Window.getClientWidth() - (MENU_WITH + MENU_MARGIN + padding * 2), 
                                Style.Unit.PX);
        root.setWidgetTopHeight(menuModule, NORTH_HEIGHT + padding, Style.Unit.PX, MENU_MODULE_HEIGHT, Style.Unit.PX);

        
        root.setWidgetLeftWidth(west, 0, PCT, MENU_WITH, Style.Unit.PX);
        root.setWidgetTopHeight(west, NORTH_HEIGHT, Style.Unit.PX, (Window.getClientHeight() - NORTH_HEIGHT), Style.Unit.PX);

        root.setWidgetLeftWidth(center, MENU_WITH + MENU_MARGIN, Style.Unit.PX, (Window.getClientWidth() - (MENU_WITH + MENU_MARGIN)), Style.Unit.PX);
        root.setWidgetTopHeight(center, NORTH_HEIGHT + padding + MENU_MODULE_HEIGHT , 
                                        Style.Unit.PX, 
                                        (Window.getClientHeight() - (NORTH_HEIGHT + (padding*2) + MENU_MODULE_HEIGHT)), Style.Unit.PX);
        

        root.setWidgetLeftWidth(south, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(south, 0, PCT, 0, PCT);

        root.setWidgetLeftWidth(east, 0, PCT, 0, PCT);
        root.setWidgetTopHeight(east, 0, PCT, 0, PCT);

        root.animate(500);
    }
}
