package com.logikas.kratos.core.event;

public abstract class EntityEvent<T> {
  
  private final T entity;
  
  protected EntityEvent(T entity) {
    this.entity = entity;    
  }
  
  public T getEntity() {
    return entity;
  }
}
