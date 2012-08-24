package com.logikas.kratos.core.event;

import com.google.common.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Named;

public class EntityListeners {

  private final EventBus createBus;

  private final EventBus updateBus;

  private final EventBus deleteBus;

  @Inject
  EntityListeners(@Named("create") EventBus createBus, @Named("update") EventBus updateBus,
      @Named("delete") EventBus deleteBus) {
    this.createBus = createBus;
    this.updateBus = updateBus;
    this.deleteBus = deleteBus;
  }

  public void onCreate(Object entity) {
    createBus.post(entity);
  }

  public void onUpdate(Object entity) {
    updateBus.post(entity);
  }

  public void onDelete(Object entity) {
    deleteBus.post(entity);
  }
}
