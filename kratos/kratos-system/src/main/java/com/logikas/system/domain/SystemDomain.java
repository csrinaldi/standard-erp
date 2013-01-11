package com.logikas.system.domain;

import com.logikas.common.persistence.domain.jpa.JpaPersistable;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
@Entity
@Table(name = "system_domain")
public class SystemDomain extends JpaPersistable<Long> {

  private static final long serialVersionUID = 1L;

  private String name;

  @OneToMany(mappedBy = "domain")
  @JoinColumn(name = "domain_id")
  private List<SystemAction> actions;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SystemAction> getActions() {
    return Collections.unmodifiableList(actions);
  }
}
