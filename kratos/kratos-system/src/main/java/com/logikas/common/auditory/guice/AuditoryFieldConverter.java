package com.logikas.common.auditory.guice;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface AuditoryFieldConverter<From, To> {

  To to(From input);
  
  From from(To to);
}
