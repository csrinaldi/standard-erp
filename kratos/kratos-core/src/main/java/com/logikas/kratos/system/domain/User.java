package com.logikas.kratos.system.domain;

import com.logikas.kratos.core.domain.HasName;

import com.google.common.base.Objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
// , schema = "system")
public class User implements Serializable, HasName {

  private Long id;

  private long version;

  private String name;

  private UserAvatar avatar;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Version
  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
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

  @OneToOne
  @JoinColumn(name = "avatar_id")
  public UserAvatar getAvatar() {
    return avatar;
  }

  public void setAvatar(UserAvatar avatar) {
    this.avatar = avatar;
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
