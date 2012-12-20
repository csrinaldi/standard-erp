/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.core.security.ioc;

import com.google.inject.Provides;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.realm.text.IniRealm;

/**
 * Kratos Security OSGi Bundle
 *
 * Documentation of Class SecurityModule
 *
 *
 * Package: com.logikas.core.security.ioc Last modification: 12/12/2012 File:
 * SecurityModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class SecurityModule extends ShiroModule {

    @Override
    protected void configureShiro() {
        try {
            bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        } catch (NoSuchMethodException e) {
            addError(e);
        }
    }

    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("classpath:shiro.ini");
    }
}
