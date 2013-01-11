package com.logikas.common.auditory.domain;

import com.logikas.common.persistence.domain.Persistable;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface Auditable<S, ID extends Serializable> extends Persistable<ID> {

  Date getCreatedDate();

  void setCreatedDate(Date createdDate);

  S getCreatedBy();

  void setCreatedBy(S createdBy);

  Date getUpdatedDate();

  void setUpdatedDate(Date updatedDate);

  S getUpdatedBy();

  void setUpdatedBy(S updatedBy);
}
