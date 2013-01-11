package com.logikas.common.persistence.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class SoftDeletables {

  private SoftDeletables() {
  }

  public static <ID extends Serializable> void deleteAll(
      Iterable<? extends SoftDeletable<ID>> softDeletables, Date deletedDate) {
    for (final SoftDeletable<ID> sd : softDeletables) {
      sd.setDeletedDate(deletedDate);
    }
  }
}
