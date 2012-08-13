package com.logikas.kratos.commons.ioc;

import com.logikas.kratos.core.repository.Repository;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.util.Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class RepositoryModule extends AbstractModule {
  /*
   * private final MapBinder<Class<?>, Repository<?, ?>> mapBinder;
   * 
   * @SuppressWarnings({"rawtypes", "unchecked"}) public RepositoryModule() { mapBinder =
   * (MapBinder) MapBinder.newMapBinder(binder(), Class.class, Repository.class); }
   */@Override
  final protected void configure() {

    configureRepositories();
  }

  protected abstract void configureRepositories();

  /*
   * protected <T> void repository(Class<T> domainType, Class<? extends Repository<T, ?>>
   * repositoryType) { mapBinder.addBinding(domainType).to(repositoryType); }
   */

  protected <T, I, R extends Repository<T, I>> void registerRepository(Key<R> repositoryKey) {

    final TypeLiteral<?> literal = repositoryKey.getTypeLiteral().getSupertype(Repository.class);

    final ParameterizedType generic = ((ParameterizedType) literal.getType());

    @SuppressWarnings({"unchecked", "rawtypes"})
    final TypeLiteral<Repository<T, I>> appliedGeneric = (TypeLiteral) TypeLiteral.get(generic);

    final Type domainType = generic.getActualTypeArguments()[0];

    final Type idType = generic.getActualTypeArguments()[1];

    @SuppressWarnings({"rawtypes", "unchecked"})
    final TypeLiteral<RepositoryProvider<T, I, R>> providerType =
        (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(RepositoryProvider.class,
            domainType, idType, repositoryKey.getTypeLiteral().getType()));

    bind(appliedGeneric).toProvider(providerType);

  }

  protected <T, I, R extends Repository<T, I>> LinkedBindingBuilder<R> bindRepository(
      Key<R> repositoryKey) {
    registerRepository(repositoryKey);
    return bind(repositoryKey);
  }

  protected <T, I, R extends Repository<T, I>> LinkedBindingBuilder<R> bindRepository(
      Class<R> repositoryType) {
    registerRepository(Key.get(repositoryType));
    return bind(repositoryType);
  }

  protected <T, I, R extends Repository<T, I>> LinkedBindingBuilder<R> bindRepository(
      TypeLiteral<R> repositoryType) {
    registerRepository(Key.get(repositoryType));
    return bind(repositoryType);
  }
}
