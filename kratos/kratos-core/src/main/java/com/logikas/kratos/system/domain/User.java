package com.logikas.kratos.system.domain;

import com.logikas.kratos.core.domain.HasName;

import com.google.common.base.Objects;

import java.io.Serializable;

public class User implements Serializable, HasName {

  private Long id;

  private Long version;
  
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getVersion() {
    return version;
  }
  
  public void setVersion(Long version) {
    this.version = version;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(User.class).add("id", getId()).add("name", getName()).toString();
  }
}
