/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.system.client;

import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.logikas.kratos.core.plugin.client.jso.JsoMenuNodeBuilder;
import com.logikas.kratos.core.plugin.client.jso.JsoPluginDescriptionBuilder;
import com.logikas.kratos.core.plugin.shared.Plugin;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;
import com.logikas.kratos.system.client.mvp.SystemPlaceHistoryMapper;
import com.logikas.kratos.system.shared.place.CreateUserPlace;

/**
 *
 * @author cristian
 */
public class SystemPlugin implements Plugin {

    private final SystemPlaceHistoryMapper historyMapper;

    @Inject
    public SystemPlugin(SystemPlaceHistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    public void boot() {
        
    }

    public void shutdown() {
    }

    public PluginDescription getDescription() {
        String token = historyMapper.getToken(new CreateUserPlace());

        final JsoMenuNodeBuilder nodeBuilder = new JsoMenuNodeBuilder();
        nodeBuilder.title("System");
        nodeBuilder.tooltip("Módulo de Sistema");
        nodeBuilder.token(token);

        final JsoPluginDescriptionBuilder builder = new JsoPluginDescriptionBuilder();
        builder.name("system");
        builder.version("1.0");
        builder.menu(nodeBuilder.menuNode());
        return builder.getDescription();
    }
}
