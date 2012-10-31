/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client.ioc;

import com.google.gwt.inject.client.AbstractGinModule;
import com.logikas.hipokrates.patient.client.view.DasboardPatientView;
import com.logikas.hipokrates.patient.client.widget.DashboardPatientWidget;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
public class PatientClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(DasboardPatientView.class).to(DashboardPatientWidget.class).in(Singleton.class);
  }
}
