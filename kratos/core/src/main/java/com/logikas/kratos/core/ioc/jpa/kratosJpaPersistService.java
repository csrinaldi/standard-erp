/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.jpa;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;
import com.logikas.kratos.core.ioc.jpa.annotations.Jpa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.datanucleus.api.jpa.JPAEntityManagerFactory;
import org.datanucleus.metadata.PersistenceUnitMetaData;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class kratosJpaService
 *
 *
 * Package: com.logikas.kratos.core.ioc.jpa Last modification: 25/11/2012 File:
 * kratosJpaService.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
@Singleton
public class kratosJpaPersistService implements Provider<EntityManager>, PersistService, UnitOfWork, DynamicPersist {

    private final ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();
    private volatile EntityManagerFactory emFactory;
    private final String persistenceUnitName;
    private Properties persistenceProperties;
    private PersistenceUnitMetaData pumb = null;

    @Inject
    public kratosJpaPersistService(@Jpa String persistenceUnitName) {
        
        this.persistenceUnitName = persistenceUnitName;
        
        this.pumb = new PersistenceUnitMetaData(persistenceUnitName, "RESOURCE_LOCAL", null);
        //this.pumb.setProvider("org.datanucleus.jpa.PersistenceProviderImp");
        //this.pumb.addProperty("datanucleus.primaryClassLoader", this.getClass().getClassLoader().toString() );
        //this.pumb.addProperty("datanucleus.plugin.pluginRegistryClassName", "org.datanucleus.plugin.OSGiPluginRegistry");
        this.pumb.addProperty("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        this.pumb.addProperty("javax.persistence.jdbc.url", "jdbc:mysql://localhost/kratosdb");
        this.pumb.addProperty("javax.persistence.jdbc.user", "root");
        this.pumb.addProperty("javax.persistence.jdbc.password", "GUN5NR0535");
        this.pumb.addProperty("datanucleus.autoCreateSchema", "true");
        
        
    }

    @Override
    public void begin() {
        entityManager.set(emFactory.createEntityManager());
    }

    @Override
    public void end() {
        EntityManager em = entityManager.get();

        // Let's not penalize users for calling end() multiple times.
        if (null == em) {
            return;
        }

        em.close();
        entityManager.remove();
    }

    @Override
    public EntityManager get() {
        if (!isWorking()) {
            begin();
        }

        EntityManager em = entityManager.get();
        //TODO
        return em;
    }

    public boolean isWorking() {
        return entityManager.get() != null;
    }

    @Override
    public synchronized void start() {
        //Preconditions.checkState(null == emFactory, "Persistence service was already initialized.");
        if (persistenceProperties != null) {
            //TODO hacer las propieades convertir a MAP
        }
        
        Map<Object, Object> overrideProps = new HashMap();
        overrideProps.put("datanucleus.primaryClassLoader", this.getClass().getClassLoader());
        overrideProps.put("datanucleus.plugin.pluginRegistryClassName", "org.datanucleus.plugin.OSGiPluginRegistry");
        this.emFactory = new JPAEntityManagerFactory(this.pumb, overrideProps);
        
        System.out.println("Persistence service was already initialized");

    }

    @Override
    public synchronized void stop() {
        Preconditions.checkState(emFactory.isOpen(), "Persistence service was already shut down.");
        emFactory.close();
        emFactory = null;
        
        System.out.println("Persistence service was already shut down");
    }

    @Override
    public void reloadClasses(Set<Class<?>> classes) {
        stop();

        Iterator<Class<?>> it = classes.iterator();
        while (it.hasNext()) {
            Class<?> object = it.next();
            System.out.println("Persistence service load new class "+object.getCanonicalName());
            this.pumb.addClassName(object.getCanonicalName());
        }
        start();
    }

    @Singleton
    public static class EntityManagerFactoryProvider implements Provider<EntityManagerFactory> {

        private final kratosJpaPersistService emProvider;

        @Inject
        public EntityManagerFactoryProvider(kratosJpaPersistService emProvider) {
            this.emProvider = emProvider;
        }

        @Override
        public EntityManagerFactory get() {
            assert null != emProvider.emFactory;
            return emProvider.emFactory;
        }
    }
}
