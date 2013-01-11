package com.logikas.common.cache;

import com.google.common.base.Ticker;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class Cacheables {

  static final int UNSET_INT = -1;

  static class UnsetWeigher implements Weigher<Object, Object> {

    @Override
    public int weigh(Object key, Object value) {
      throw new UnsupportedOperationException("Invalid Weigher");
    }
  }

  static class UnsetTicker extends Ticker {

    @Override
    public long read() {
      throw new UnsupportedOperationException("Invalid Ticker");
    }
  }

  static class UnsetRemovalListener implements RemovalListener<Object, Object> {

    @Override
    public void onRemoval(RemovalNotification<Object, Object> notification) {
      throw new UnsupportedOperationException("Invalid RemovalListener");
    }
  }

  public static boolean isSet(long value) {
    return value != UNSET_INT;
  }

  public static boolean isWeigherSet(Class<? extends Weigher<?, ?>> weigherType) {
    return !weigherType.equals(UnsetWeigher.class);
  }

  public static boolean isTickerSet(Class<? extends Ticker> tickerType) {
    return !tickerType.equals(UnsetTicker.class);
  }

  public static boolean isRemovalListenerSet(
      Class<? extends RemovalListener<?, ?>> removalListenerType) {
    return !removalListenerType.equals(UnsetRemovalListener.class);
  }

  public static boolean isSet(Cacheable.Duration duration) {
    return isSet(duration.duration());
  }
}
