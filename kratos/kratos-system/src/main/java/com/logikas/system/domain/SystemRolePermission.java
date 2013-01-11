package com.logikas.system.domain;

import com.logikas.common.auditory.domain.jpa.JpaAuditable;
import com.logikas.common.persistence.domain.Expirable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
@Entity
@Table(name = "system_role_permission")
public class SystemRolePermission extends JpaAuditable<SystemUser, Long> implements Expirable<Long> {

  private static final long serialVersionUID = 1L;

  @Version
  private Integer version;

  @ManyToOne(optional = false)
  @JoinColumn(name = "role_id")
  private SystemRole role;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expiration_date")
  private Date expirationDate;
  
  @Column(name = "wildcard")
  private String wildcard;
  
  @ManyToOne
  private SystemAction action;
  
  public Integer getVersion() {
    return version;
  }
  
  protected void setVersion(Integer version) {
    this.version = version;
  }
  
  public SystemRole getRole() {
    return role;
  }
  
  protected void setRole(SystemRole role) {
    this.role = role;
  }

  @Override
  public Date getExpirationDate() {
    return expirationDate;
  }

  @Override
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
  
  public String getWildcard() {
    return wildcard;
  }
  
  public void setWildcard(String wildcard) {
    this.wildcard = wildcard;
  }
  
  public SystemAction getAction() {
    return action;
  }
  
  public void setAction(SystemAction action) {
    this.action = action;
  }
}
