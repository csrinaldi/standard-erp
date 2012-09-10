package com.logikas.kratos.core.ioc;

import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.EntityFinderLocator;
import com.logikas.kratos.core.repository.EntityFinders;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import java.util.HashMap;

public class AutodiscoveredEntityFinderModule extends AbstractModule {

  private static class EntityFinderLocatorImpl implements EntityFinderLocator {

    final HashMap<Class<?>, EntityFinder<?, ?>> finders =
        new HashMap<Class<?>, EntityFinder<?, ?>>();

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public <T> EntityFinder<T, ?> get(Class<T> domainType) {
      return (EntityFinder) finders.get(domainType);
    }
  }

  @Override
  protected void configure() {

    final EntityFinderLocatorImpl locator = new EntityFinderLocatorImpl();

    final Matcher<TypeLiteral<?>> matcher = new AbstractMatcher<TypeLiteral<?>>() {

      @Override
      public boolean matches(TypeLiteral<?> literal) {

        return EntityFinder.class.isAssignableFrom(literal.getRawType());
      }
    };

    final InjectionListener<EntityFinder<?, ?>> injectionListener =
        new InjectionListener<EntityFinder<?, ?>>() {

          @Override
          public void afterInjection(EntityFinder<?, ?> finder) {

            @SuppressWarnings({"unchecked", "rawtypes"})
            final Class<?> domainType = EntityFinders.getDomainType((Class) finder.getClass());

            locator.finders.put(domainType, finder);
          }
        };

    final TypeListener typeListener = new TypeListener() {

      final HashMap<Class<?>, Class<? extends EntityFinder<?, ?>>> registeredTypes =
          new HashMap<Class<?>, Class<? extends EntityFinder<?, ?>>>();

      @SuppressWarnings({"rawtypes", "unchecked"})
      @Override
      public <I> void hear(TypeLiteral<I> literal, TypeEncounter<I> encounter) {

        final Class<?> finderType = literal.getRawType();

        if (EntityFinder.class.isAssignableFrom(literal.getRawType())) {

          final TypeEncounter<EntityFinder<?, ?>> finderEncounter =
              (TypeEncounter<EntityFinder<?, ?>>) encounter;

          final Class<?> domainType = EntityFinders.getDomainType((Class) finderType);

          final Class<? extends EntityFinder<?, ?>> previousFinderType =
              registeredTypes.get(domainType);

          if (previousFinderType != null) {

            encounter.addError("EntityFinder for entity %s was registered twice: %s and %s",
                domainType.getName(), previousFinderType.getName(), finderType.getName());

          } else {

            registeredTypes.put(domainType, (Class) finderType);

            finderEncounter.register(injectionListener);
          }
        }
      }
    };

    bind(EntityFinderLocator.class).toInstance(locator);

    bindListener(matcher, typeListener);
  }
}
