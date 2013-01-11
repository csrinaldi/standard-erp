package com.logikas.common.auditory.guice;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class FieldAttributeAccessor<E, T> implements AttributeAccessor<E, T> {

  private final Field field;

  FieldAttributeAccessor(Field field) {
    this.field = field;
  }

  @Override
  public String getName() {
    return field.getName();
  }

  @Override
  public Member getMember() {
    return field;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T getValue(E entity) throws Throwable {
    return (T) field.get(entity);
  }

  @Override
  public void setValue(E entity, T value) throws Throwable {
    field.set(entity, value);
  }

  public static <E, T> AttributeAccessor<E, T> tryCreate(Field field) {
    // if (!field.isAccessible()) {
    // return null;
    // }
    return new FieldAttributeAccessor<>(field);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<? extends T> getValueType() {
    return (Class<? extends T>) field.getType();
  }
}
