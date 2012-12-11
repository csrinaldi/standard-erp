/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.jpa;

import com.google.common.base.Preconditions;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;
import com.logikas.kratos.core.ioc.jpa.annotations.Jpa;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class JPADynamicPersistModule
 *
 *
 * Package: com.logikas.kratos.core.ioc.jpa Last modification: 26/11/2012 File:
 * JPADynamicPersistModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class KratosPersistModule extends PersistModule {

    private String jpaUnit;
    private Properties properties;
    private MethodInterceptor transactionInterceptor;

    public KratosPersistModule(String jpaUnit) {
        Preconditions.checkArgument(null != jpaUnit && jpaUnit.length() > 0,
                "JPA unit name must be a non-empty string.");
        this.jpaUnit = jpaUnit;
    }

    @Override
    protected void configurePersistence() {
        bindConstant().annotatedWith(Jpa.class).to(jpaUnit);

        //if (null != properties) {
        //    bind(Properties.class).annotatedWith(Jpa.class).toInstance(properties);
        //} else {
        //    bind(Properties.class).annotatedWith(Jpa.class)
        //.toProvider(Providers.<Properties>of(null));
        //}

        bind(kratosJpaPersistService.class).in(Singleton.class);

        bind(PersistService.class).to(kratosJpaPersistService.class);
        bind(UnitOfWork.class).to(kratosJpaPersistService.class);
        bind(DynamicPersist.class).to(kratosJpaPersistService.class);
        
        bind(EntityManager.class).toProvider(kratosJpaPersistService.class);
        bind(EntityManagerFactory.class)
                .toProvider(kratosJpaPersistService.EntityManagerFactoryProvider.class);



        transactionInterceptor = new kratosJpaTxnInterceptor();
        requestInjection(transactionInterceptor);

        //TODO bin dynamic fnder

    }

    @Override
    protected MethodInterceptor getTransactionInterceptor() {
        //TODO
        return transactionInterceptor;
    }
}
