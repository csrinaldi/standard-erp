package com.logikas.common.auditory.domain.jpa;

import com.logikas.common.auditory.domain.Auditable;
import com.logikas.common.persistence.domain.jpa.JpaPersistable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@MappedSuperclass
public abstract class JpaAuditable<S, ID extends Serializable> extends JpaPersistable<ID> implements
    Auditable<S, ID> {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "created_by_id")
  private S createdBy;

  @Column(name = "created_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @ManyToOne
  @JoinColumn(name = "updated_by_id")
  private S updatedBy;

  @Column(name = "updated_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedDate;

  @Override
  public Date getCreatedDate() {
    return createdDate;
  }

  @Override
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public S getCreatedBy() {
    return createdBy;
  }

  @Override
  public void setCreatedBy(S createdBy) {
    this.createdBy = createdBy;
  }

  @Override
  public Date getUpdatedDate() {
    return updatedDate;
  }

  @Override
  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Override
  public S getUpdatedBy() {
    return updatedBy;
  }

  @Override
  public void setUpdatedBy(S updatedBy) {
    this.updatedBy = updatedBy;
  }

}
