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
@Table(name = "system_user_token")
public class SystemUserToken extends JpaAuditable<SystemUser, Long> implements Expirable<Long> {

  private static final long serialVersionUID = 1L;

  @Version
  private Integer version;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
  private SystemUser user;

  @Column(name = "token")
  private String token;

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
  
  protected void setUser(SystemUser user) {
    this.user = user;
  }
  
  public String getToken() {
    return token;
  }
  
  public void setToken(String token) {
    this.token = token;
  }  
  
  @Override
  public Date getExpirationDate() {
    return expirationDate;
  }
  
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
}
