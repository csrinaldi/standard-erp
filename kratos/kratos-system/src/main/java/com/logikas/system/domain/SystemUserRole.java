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
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@Entity
@Table(name = "system_user_role")
public class SystemUserRole extends JpaAuditable<SystemUser, Long> implements Expirable<Long> {

  private static final long serialVersionUID = 1L;

  @Version
  private Integer version;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
  private SystemUser user;

  @ManyToOne(optional = false)
  @JoinColumn(name = "role_id")
  private SystemRole role;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expiration_date")
  private Date expirationDate;
  
  public Integer getVersion() {
    return version;
  }
  
  protected void setVersion(Integer version) {
    this.version = version;
  }
    
  public SystemUser getUser() {
    return user;
  }
  
  public void setUser(SystemUser user) {
    this.user = user;
  }

  public SystemRole getRole() {
    return role;
  }
  
  public void setRole(SystemRole role) {
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
}
