package com.logikas.common.cache;


import static com.logikas.common.cache.Cacheables.UNSET_INT;

import com.google.common.base.Ticker;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import com.logikas.common.cache.Cacheables.UnsetRemovalListener;
import com.logikas.common.cache.Cacheables.UnsetTicker;
import com.logikas.common.cache.Cacheables.UnsetWeigher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Duration {

    long duration();

    TimeUnit unit();
  }

  int initialCapacity() default UNSET_INT;

  int concurrencyLevel() default UNSET_INT;

  long maximumSize() default UNSET_INT;

  long maximumWeight() default UNSET_INT;

  Class<? extends Weigher<? extends Object, ? extends Object>> weigher() default UnsetWeigher.class;

  boolean weakKeys() default false;

  boolean weakValues() default false;

  boolean softValues() default false;

  Duration expireAfterWrite() default @Duration(duration = UNSET_INT, unit = TimeUnit.MILLISECONDS);

  Duration expireAfterAccess() default @Duration(duration = UNSET_INT, unit = TimeUnit.MILLISECONDS);

  Duration refreshAfterWrite() default @Duration(duration = UNSET_INT, unit = TimeUnit.MILLISECONDS);

  Class<? extends Ticker> ticker() default UnsetTicker.class;

  Class<? extends RemovalListener<?, ?>> removalListener() default UnsetRemovalListener.class;

  boolean recordStats() default false;

  boolean wrapSingleArguments() default false;
}
