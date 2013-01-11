package com.logikas.common.auditory.guice;

import java.lang.reflect.Member;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface AttributeAccessor<E, T> {
  
  String getName();
  
  T getValue(E entity) throws Throwable;
  
  void setValue(E entity, T value) throws Throwable;
  
  Member getMember();
  
  Class<? extends T> getValueType();
}
