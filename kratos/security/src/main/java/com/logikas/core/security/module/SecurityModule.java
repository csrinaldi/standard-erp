package com.logikas.core.security.module;

import com.logikas.kratos.core.module.Module;

/**
 * Representa el Modulo de Seguridad en Kratos, este modulo contiene
 * interfaces e implementaciones de la seguridad en el sistema.
 * 
 * @author Cristian Rinaldi
 * Logikas - Conectando Ideas
 * 
 */

public class SecurityModule implements Module{

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public Boolean initialize() {
        return true;
    }

    @Override
    public Boolean isActive() {
        return true;
    }

    @Override
    public Boolean shutdown() {
        return true;
    }
    
}
