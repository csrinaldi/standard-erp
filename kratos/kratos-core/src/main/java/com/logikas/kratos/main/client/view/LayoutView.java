/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * 
 * @author csrinaldi
 */
public interface LayoutView extends IsWidget {

  AcceptsOneWidget getCenterRegion();

  AcceptsOneWidget getWestRegion();
  
  AcceptsOneWidget getSouthRegion();
  
  void setDefaultLayout();

}
