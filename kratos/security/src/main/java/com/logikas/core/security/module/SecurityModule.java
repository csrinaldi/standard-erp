package com.logikas.core.security.module;

import com.logikas.core.security.persistence.User;
import com.logikas.kratos.core.persistence.api.PersistenceModule;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Representa el Modulo de Seguridad en Kratos, este modulo contiene
 * interfaces e implementaciones de la seguridad en el sistema.
 * 
 * @author Cristian Rinaldi
 * Logikas - Conectando Ideas
 * 
 */

public class SecurityModule implements PersistenceModule{

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

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Class<?>> getPersistentClasses() {
        Set<Class<?>> sets = new LinkedHashSet<Class<?>>();
        sets.add(User.class);
        //Reflections reflections = new Reflections("com.logikas.core.security.persistence");
        //Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
        return sets;
    }
    
}
