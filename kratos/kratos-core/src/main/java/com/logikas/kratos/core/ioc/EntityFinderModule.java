package com.logikas.kratos.core.ioc;

import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.EntityFinders;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

public abstract class EntityFinderModule extends AbstractModule {
  
  @SuppressWarnings("rawtypes")
  private MapBinder<Class, EntityFinder> entityFinders = null;
  
  @Override
  protected final void configure() {
    entityFinders = MapBinder.newMapBinder(binder(), Class.class, EntityFinder.class);
    configureEntityFinders();
  }
    
  protected abstract void configureEntityFinders();
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  protected <T extends EntityFinder> LinkedBindingBuilder<T> bindFinder(Key<T> key) {
    
    return (LinkedBindingBuilder) entityFinders.addBinding(EntityFinders.getDomainType((Class)key.getTypeLiteral().getType()));
  }
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  protected <T extends EntityFinder> LinkedBindingBuilder<T> bindFinder(TypeLiteral<T> literal) {
    return (LinkedBindingBuilder) entityFinders.addBinding(EntityFinders.getDomainType((Class)literal.getType()));
  }
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  protected <T extends EntityFinder> LinkedBindingBuilder<T> bindFinder(Class<T> clazz) {
    return (LinkedBindingBuilder) entityFinders.addBinding(EntityFinders.getDomainType((Class)clazz));
  }
}
