package com.logikas.system.service;

import com.logikas.system.domain.SystemUser;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
public interface SystemUserService {
  
  void authenticate(String username, String password);

  void save(SystemUser user);
}
