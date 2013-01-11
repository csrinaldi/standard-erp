package com.logikas.common.auditory.domain.jpa;

import com.logikas.common.persistence.domain.SoftDeletable;

import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@Where(clause = "deleted_date IS NULL")
@MappedSuperclass
public abstract class JpaSoftDeletableAuditable<S, ID extends Serializable> extends
    JpaAuditable<S, ID> implements SoftDeletable<ID> {

  private static final long serialVersionUID = 1L;

  @Column(name = "deleted_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deletedDate;

  @Override
  public Date getDeletedDate() {
    return deletedDate;
  }

  @Override
  public void setDeletedDate(Date deletedDate) {
    this.deletedDate = deletedDate;
    onSoftDelete(deletedDate);
  }
  
  protected void onSoftDelete(Date deletedDate) {    
  }
}
