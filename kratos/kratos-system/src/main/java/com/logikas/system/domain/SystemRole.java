package com.logikas.system.domain;

import com.logikas.common.auditory.domain.jpa.JpaAuditable;
import com.logikas.common.persistence.domain.Expirable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 21/12/2012
 */
@Entity
@Table(name = "system_role")
public class SystemRole extends JpaAuditable<SystemUser, Long> implements Expirable<Long> {

  private static final long serialVersionUID = 1L;

  @Version
  private Integer version;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "role")
  private List<SystemRolePermission> rolePermissions = new ArrayList<SystemRolePermission>();

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expiration_date")
  private Date expirationDate;
  
  public Integer getVersion() {
    return version;
  }
  
  public void setVersion(Integer version) {
    this.version = version;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public List<SystemRolePermission> getRolePermissions() {
    return Collections.unmodifiableList(rolePermissions);
  }
  
  public void addRolePermission(SystemRolePermission rolePermission) {
    rolePermission.setRole(this);
    rolePermissions.add(rolePermission);
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
