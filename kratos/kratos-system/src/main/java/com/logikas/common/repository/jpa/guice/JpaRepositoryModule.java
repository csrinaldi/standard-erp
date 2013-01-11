package com.logikas.common.repository.jpa.guice;


import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.persist.Transactional;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.logikas.common.repository.jpa.JpaRepositories;
import com.logikas.common.repository.jpa.JpaRepository;
import com.logikas.common.repository.jpa.Transactor;

import java.util.Date;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class JpaRepositoryModule extends AbstractModule {

  @Override
  protected void configure() {

    requireBinding(EntityManager.class);
    requireBinding(Date.class);

    bind(Transactor.class).toInstance(new Transactor() {

      @Transactional
      @Override
      public <T> T perform(Execution<T> e) {
        return e.execute();
      }
    });

    final Matcher<TypeLiteral<?>> matcher = new AbstractMatcher<TypeLiteral<?>>() {
      @Override
      public boolean matches(TypeLiteral<?> t) {
        return JpaRepository.class.isAssignableFrom(t.getRawType());
      }
    };

    bindListener(matcher, new TypeListener() {

      @Override
      public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {

        final Provider<EntityManager> em = encounter.getProvider(EntityManager.class);
        final Provider<Transactor> transactor = encounter.getProvider(Transactor.class);
        final Provider<Date> now = encounter.getProvider(Date.class);

        encounter.register(new InjectionListener<I>() {

          @Override
          public void afterInjection(I injectee) {
            JpaRepositories.initialize((JpaRepository<?, ?>) injectee, em, transactor, now);
          }
        });
      }
    });
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof JpaRepositoryModule;
  }

  @Override
  public int hashCode() {
    return JpaRepositoryModule.class.hashCode();
  }
}
