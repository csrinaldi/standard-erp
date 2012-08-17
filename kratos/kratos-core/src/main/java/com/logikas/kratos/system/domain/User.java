package com.logikas.kratos.system.domain;

import com.logikas.kratos.core.domain.GenericEntity;
import com.logikas.kratos.core.domain.HasName;

import com.google.common.base.Objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user") //, schema = "juanca")
public class User implements Serializable, GenericEntity, HasName {

  private Long id;

  private Long version;

  private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Version
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  @NotNull
  @Size(min = 5, max = 20)
  @Column(name = "name", unique = true)
  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof User)) {
      return false;
    }
    final User user = (User) other;
    return Objects.equal(this.getId(), user.getId());
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(User.class).add("id", getId()).add("name", getName()).toString();
  }
}
