package com.logikas.system.domain;

import com.logikas.common.auditory.domain.jpa.JpaSoftDeletableAuditable;
import com.logikas.common.persistence.domain.Expirable;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
@Entity
@Table(name = "system_user")
public class SystemUser extends JpaSoftDeletableAuditable<SystemUser, Long> implements Expirable<Long>, SystemSubject {

  private static final long serialVersionUID = -6404817788074875608L;

  @Version
  @Column(name = "version")
  private Integer version;

  @Size(min = 6, max = 20)
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "user")
  private List<SystemUserRole> userRoles;

  @OneToMany(mappedBy = "user")
  @OrderBy("creationDate DESC")
  private List<SystemUserToken> userTokens;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expiration_date")
  private Date expirationDate;

  public Integer getVersion() {
    return version;
  }

  protected void setVersion(Integer version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SystemUserRole> getUserRoles() {
    return Collections.unmodifiableList(userRoles);
  }

  public void addUserRole(SystemUserRole userRole) {
    userRole.setUser(this);
    userRoles.add(userRole);
  }

  public List<SystemUserToken> getUserTokens() {
    return Collections.unmodifiableList(userTokens);
  }

  public void addUserToken(SystemUserToken userToken) {
    userToken.setUser(this);
    userTokens.add(userToken);
  }

  @Override
  public Date getExpirationDate() {
    return expirationDate;
  }

  @Override
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
}
