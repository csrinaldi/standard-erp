/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.ui.client;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * 
 * @author csrinaldi
 */
public interface LayoutView extends IsWidget {

  AcceptsOneWidget getNorthRegion();  
    
  AcceptsOneWidget getCenterRegion();

  AcceptsOneWidget getWestRegion();
  
  AcceptsOneWidget getSouthRegion();
  
  AcceptsOneWidget getMenuModuleRegion();
  
  void setDefaultLayout();

}
