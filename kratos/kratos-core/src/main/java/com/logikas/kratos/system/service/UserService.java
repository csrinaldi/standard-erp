package com.logikas.kratos.system.service;

import com.logikas.kratos.commons.validation.Validated;
import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.validation.Admin;

import java.util.List;

public interface UserService {
  
  User find(Long id);  
  
  @Validated
  void save(@Admin User user);
  
  List<User> findByName(String name, int start, int rows);
  
  List<User> findAll(int start, int rows);

  boolean isAdmin(User user);
}
