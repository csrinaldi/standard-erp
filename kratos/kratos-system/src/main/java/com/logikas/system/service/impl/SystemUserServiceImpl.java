package com.logikas.system.service.impl;

import com.logikas.system.domain.SystemUser;
import com.logikas.system.repository.SystemUserRepository;
import com.logikas.system.service.SystemUserService;

import javax.inject.Inject;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
public class SystemUserServiceImpl implements SystemUserService {

  private final SystemUserRepository repository;

  @Inject
  SystemUserServiceImpl(SystemUserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(SystemUser user) {
    repository.save(user);
  }

  @Override
  public void authenticate(String username, String password) {

  }
}
