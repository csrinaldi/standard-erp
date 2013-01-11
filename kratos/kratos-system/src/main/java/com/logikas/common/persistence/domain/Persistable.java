package com.logikas.common.persistence.domain;

import java.io.Serializable;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface Persistable<ID extends Serializable> extends Serializable {

  ID getId();

  boolean isNew();
  
  boolean equals(Object o);
  
  int hashCode();
  
  String toString();
}
