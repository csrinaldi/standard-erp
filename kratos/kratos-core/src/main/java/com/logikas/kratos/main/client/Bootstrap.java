package com.logikas.kratos.main.client;

import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Label;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Bootstrap {
  
  private final InsertPanel.ForIsWidget mainPanel;
  
  @Inject
  Bootstrap(@Named("mainPanel") InsertPanel.ForIsWidget mainPanel) {
    this.mainPanel = mainPanel;
  }
  
  public void init() {
    mainPanel.add(new Label("hello world"));    
  }
}
