package com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.jboss.errai.ui.nav.client.local.Navigation;

@EntryPoint
public class HelloWorldClient extends VerticalPanel {

    @Inject
    Navigation navigation;

    @PostConstruct
    public void init() {
        RootPanel.get().add(navigation.getContentPanel());
        System.out.println("UI Constructed!");
    }
}
