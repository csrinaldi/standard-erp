package com.logikas.common.persistence.domain.jpa;

import com.logikas.common.persistence.domain.Persistable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class JpaPersistable<ID extends Serializable> implements Persistable<ID> {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private ID id;

  @Override
  public ID getId() {
    return id;
  }

  protected void setId(final ID id) {
    this.id = id;
  }

  @Override
  public boolean isNew() {
    return null == getId();
  }

  @Override
  public String toString() {
    return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
  }

  @Override
  public boolean equals(Object obj) {

    if (null == obj) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    if (!getClass().equals(obj.getClass())) {
      return false;
    }

    JpaPersistable<?> that = (JpaPersistable<?>) obj;

    return null == this.getId() ? false : this.getId().equals(that.getId());
  }

  @Override
  public int hashCode() {

    int hashCode = 17;

    hashCode += null == getId() ? 0 : getId().hashCode() * 31;

    return hashCode;
  }
}
