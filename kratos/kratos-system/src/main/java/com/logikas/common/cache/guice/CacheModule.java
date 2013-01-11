package com.logikas.common.cache.guice;


import static com.logikas.common.cache.Cacheables.isRemovalListenerSet;
import static com.logikas.common.cache.Cacheables.isSet;
import static com.logikas.common.cache.Cacheables.isTickerSet;
import static com.logikas.common.cache.Cacheables.isWeigherSet;

import com.google.common.base.Optional;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.Message;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.logikas.common.cache.Cacheable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

import javax.inject.Singleton;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class CacheModule extends AbstractModule {

  static class CacheableMethodMatcher extends AbstractMatcher<Method> {
    @Override
    public boolean matches(Method method) {
      final Optional<Cacheable> possibleConfig = findConfig(method);
      return possibleConfig != null && possibleConfig.isPresent();
    }
  }

  private <K, V> Cache<K, V> buildCache(Cacheable config, TypeEncounter<?> encounter) {

    final CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();

    if (isSet(config.concurrencyLevel())) {
      builder.concurrencyLevel(config.concurrencyLevel());
    }

    final Cacheable.Duration expireAfterAccess = config.expireAfterAccess();

    if (isSet(expireAfterAccess)) {
      builder.expireAfterAccess(expireAfterAccess.duration(), expireAfterAccess.unit());
    }

    final Cacheable.Duration expireAfterWrite = config.expireAfterWrite();

    if (isSet(expireAfterWrite)) {
      builder.expireAfterWrite(expireAfterWrite.duration(), expireAfterWrite.unit());
    }

    if (isSet(config.initialCapacity())) {
      builder.initialCapacity(config.initialCapacity());
    }

    if (isSet(config.maximumSize())) {
      builder.maximumSize(config.maximumSize());
    }

    if (isSet(config.maximumWeight())) {
      builder.maximumWeight(config.maximumWeight());
    }

    if (config.recordStats()) {
      builder.recordStats();
    }

    final Cacheable.Duration refreshAfterWrite = config.refreshAfterWrite();

    if (isSet(refreshAfterWrite)) {
      builder.refreshAfterWrite(refreshAfterWrite.duration(), refreshAfterWrite.unit());
    }

    if (isRemovalListenerSet(config.removalListener())) {

      @SuppressWarnings({"unchecked", "rawtypes"})
      final Provider<? extends RemovalListener<K, V>> removalListener =
          encounter.getProvider((Class) config.removalListener());

      builder.removalListener(new RemovalListener<K, V>() {

        @Override
        public void onRemoval(RemovalNotification<K, V> notification) {
          removalListener.get().onRemoval(notification);
        }
      });
    }

    if (config.softValues()) {
      builder.softValues();
    }

    if (isTickerSet(config.ticker())) {

      final Provider<? extends Ticker> ticker = encounter.getProvider(config.ticker());

      builder.ticker(new Ticker() {

        @Override
        public long read() {
          return ticker.get().read();
        }
      });
    }

    if (config.weakValues()) {
      builder.weakValues();
    }

    if (isWeigherSet(config.weigher())) {

      @SuppressWarnings({"unchecked", "rawtypes"})
      final Provider<? extends Weigher<K, V>> weigher =
          encounter.getProvider((Class) config.weigher());

      builder.weigher(new Weigher<K, V>() {

        @Override
        public int weigh(K key, V value) {
          return weigher.get().weigh(key, value);
        }
      });
    }

    return builder.build();
  }

  @Override
  protected void configure() {

    final CacheInterceptor interceptor = new CacheInterceptor();

    bindInterceptor(Matchers.any(), new CacheableMethodMatcher(), interceptor);
    
    final TypeLiteral<Map<Method, Cache<Object, Object>>> mapLiteral =
        new TypeLiteral<Map<Method, Cache<Object, Object>>>() {
        };   

    bind(mapLiteral).toProvider(interceptor).in(Singleton.class);

    bindListener(Matchers.any(), new TypeListener() {

      @Override
      public <I> void hear(TypeLiteral<I> typeLiteral, final TypeEncounter<I> encounter) {

        for (final Method method : typeLiteral.getRawType().getDeclaredMethods()) {

          final Optional<Cacheable> possibleConfig = findConfig(method);

          if (possibleConfig == null) {

            encounter.addError("Too many cache annotations for method %s", method);

          } else if (possibleConfig.isPresent()) {

            final Cacheable config = possibleConfig.get();

            if (method.getReturnType().equals(Void.TYPE)) {

              encounter.addError("Not allowed cache for void return type in method %s", method);

            } else if (method.getParameterTypes().length == 0) {

              encounter.addError("Not allowed cache for empty argument list in method %s", method);
            } else {

              try {

                final Cache<Object, Object> cache = buildCache(config, encounter);
                interceptor.addCache(method, cache, config.wrapSingleArguments());
              } catch (Exception e) {

                encounter.addError(new Message(Collections.emptyList(),
                    "Unable to build cache for method " + method, e));
              }
            }
          }
        }
      }
    });
  }

  private static Optional<Cacheable> findConfig(Method method) {

    Cacheable config = method.getAnnotation(Cacheable.class);

    final Annotation[] annotations = method.getDeclaredAnnotations();

    for (final Annotation a : annotations) {

      final Cacheable metaConfig = a.annotationType().getAnnotation(Cacheable.class);

      if (metaConfig != null) {

        if (config != null) {

          return null;
        }

        config = metaConfig;
      }
    }

    return Optional.fromNullable(config);
  }
}
