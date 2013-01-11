package com.logikas.common.cache.guice;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */

class ByPassException extends Exception {

  private static final long serialVersionUID = 1L;

  public ByPassException(Throwable cause) {
    super(cause);
  }
}
