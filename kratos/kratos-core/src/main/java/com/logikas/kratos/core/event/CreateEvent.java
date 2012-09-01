package com.logikas.kratos.core.event;

public class CreateEvent<T> extends EntityEvent<T> {
  
  public CreateEvent(T entity) {
    super(entity);
  }
}
