/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.hipokrates.patient.client.mvp.PatientActivityManager;
import com.logikas.hipokrates.patient.shared.place.DashboardPatientPlace;
import com.logikas.hipokrates.patient.shared.place.PatientPlaceHistoryMapper;
import com.logikas.kratos.core.plugin.client.jso.JsoMenuNodeBuilder;
import com.logikas.kratos.core.plugin.client.jso.JsoPluginDescriptionBuilder;
import com.logikas.kratos.core.plugin.shared.Plugin;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;
import com.logikas.kratos.core.ui.client.LayoutView;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;

/**
 *
 * @author cristian
 */
public class PatientPlugin implements Plugin {
   
    @Inject
    private PatientActivityManager activityManager;

    @Inject
    private LayoutView view;    
    
    @Inject
    private PatientPlaceHistoryMapper historyMapper;

    @Override
    public void boot() {
        activityManager.setDisplay(view.getCenterRegion());
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PluginDescription getDescription() {
        String token = historyMapper.getToken(new DashboardPatientPlace());

        final JsoMenuNodeBuilder nodeBuilder = new JsoMenuNodeBuilder();
        nodeBuilder.title("Patient");
        nodeBuilder.tooltip("Módulo de Pacientes");
        nodeBuilder.token(token);

        final JsoPluginDescriptionBuilder builder = new JsoPluginDescriptionBuilder();
        builder.name("patient");
        builder.version("1.0");
        builder.menu(nodeBuilder.menuNode());
        return builder.getDescription();
    }

    @Override
    public PlaceHistoryMapper getHistoryMapper() {
        return this.historyMapper;
    }
}
