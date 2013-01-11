package com.logikas.system.domain;

import com.logikas.common.persistence.domain.jpa.JpaPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
@Entity
@Table(name = "security_domain_action")
public class SystemAction extends JpaPersistable<Long> {

  private static final long serialVersionUID = 1L;

  @ManyToOne(optional = false)
  private SystemDomain systemDomain;

  @Column(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemDomain getSystemDomain() {
    return systemDomain;
  }

  public void setSystemDomain(SystemDomain systemDomain) {
    this.systemDomain = systemDomain;
  }
}
