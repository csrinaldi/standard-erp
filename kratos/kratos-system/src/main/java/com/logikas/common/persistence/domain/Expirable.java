package com.logikas.common.persistence.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface Expirable<ID extends Serializable> extends Persistable<ID> {
  
  Date getExpirationDate();
  
  void setExpirationDate(Date expirationDate);
}
