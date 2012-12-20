/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.modernui.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * ModernUi
 *
 * Documentation of Class Resource
 *
 *
 * Package: com.logikas.modernui.client.ui.config Last modification: 19/12/2012
 * File: Resource.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public interface Resources extends ClientBundle {

    public static Resources RESOURCES = GWT.create(Resources.class);

    /**
     * Returns the Bootstrap CSS file. <p> Override this method to use your own
     * CSS file.
     *
     * @return the Bootstrap CSS file
     */
    // Imported as a TextResource until GWT supports CSS3.
    @Source("css/bootmetro.css")
    TextResource bootmetroCss();

    /**
     * Returns the responsive extension to Bootstrap. <p> The responsive design
     * is neither injected nor activated by default. You have to implement your
     * own {@link Configurator} and let
     * {@link Configurator#hasResponsiveDesign()} return {@code true}. </p> <p>
     *
     * Override this method to provide a different version of the responsive
     * extension. <b>This may break some widgets!</b>
     *
     * @return the Bootstrap responsive extension JavaScript
     */
    @Source("css/bootmetro-responsive.css")
    TextResource bootmetroResponsiveCss();

    @Source("css/bootmetro-icons.css")
    TextResource bootmetroIconsCss();

    @Source("css/metro-ui-dark.css")
    TextResource bootmetroDarkCss();

    @Source("css/metro-ui-light.css")
    TextResource bootmetroLightCss();
    //@Source("css/font-awesome.css")
    //TextResource fontAwesomeCss();
//	@Source("js/bootstrap-collapse.js")
//	TextResource bootstrapCollapseJs();
//	@Source("css/prettify.css")
//	TextResource prettify_css();
//	@Source("js/prettify/prettify.js")
//	TextResource prettify_js();
//	@Source("js/prettify.js")
//	TextResource prettify_js();
//	@Source("js/bootstrap-alerts.js")
//	TextResource alerts();
//
//	@Source("js/bootstrap-buttons.js")
//	TextResource buttons();
//
//	@Source("js/bootstrap-dropdown.js")
//	TextResource dropdown();
//
//	@Source("js/bootstrap-modal.js")
//	TextResource modal();
//
//	@Source("js/bootstrap-popover.js")
//	TextResource popover();
//
//	@Source("js/bootstrap-scrollspy.js")
//	TextResource scrollspy();
//
//	@Source("js/bootstrap-tabs.js")
//	TextResource tabs();
//
//	@Source("js/bootstrap-twipsy.js")
//	TextResource twipsy();
}
