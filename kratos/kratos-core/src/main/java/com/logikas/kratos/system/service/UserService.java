package com.logikas.kratos.system.service;

import com.logikas.kratos.commons.validation.Validated;
import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.validation.Admin;

public interface UserService {
  
  User find(Long id);  
  
  @Validated
  void save(@Admin User user);

  boolean isAdmin(User user);
}
