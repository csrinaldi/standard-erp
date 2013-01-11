package com.logikas.common.auditory.guice;

import java.lang.reflect.Member;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class ConvertibleAttributeAccessor<E, T, C> implements AttributeAccessor<E, T> {

  private final AttributeAccessor<E, C> self;

  private final AuditoryFieldConverter<T, C> converter;

  private final Class<T> valueType;

  public ConvertibleAttributeAccessor(AttributeAccessor<E, C> self,
      AuditoryFieldConverter<T, C> converter, Class<T> valueType) {
    this.self = self;
    this.converter = converter;
    this.valueType = valueType;
  }

  @Override
  public String getName() {
    return self.getName();
  }

  @Override
  public T getValue(E entity) throws Throwable {
    return converter.from(self.getValue(entity));
  }

  @Override
  public void setValue(E entity, T value) throws Throwable {
    self.setValue(entity, converter.to(value));
  }

  @Override
  public Member getMember() {
    return self.getMember();
  }

  @Override
  public Class<? extends T> getValueType() {
    return valueType;
  }
}
