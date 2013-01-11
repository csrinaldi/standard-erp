package com.logikas.common.persistence.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface SoftDeletable<ID extends Serializable> extends Persistable<ID> {

  Date getDeletedDate();

  void setDeletedDate(Date deletedDate);
}
