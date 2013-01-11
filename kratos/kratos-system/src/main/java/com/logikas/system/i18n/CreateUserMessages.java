package com.logikas.system.i18n;

import javax.inject.Named;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface CreateUserMessages {

  String name();

  String save();

  String reset();

  String userCreated(String name);

  @Named("nameReset")
  String reset(String name);

  String saveError();

  String requiredUserName();
}
