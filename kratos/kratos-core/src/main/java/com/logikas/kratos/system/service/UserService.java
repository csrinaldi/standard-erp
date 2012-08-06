package com.logikas.kratos.system.service;

import com.logikas.kratos.system.domain.User;

public interface UserService {
  
  User find(Long id);
  
  void save(User user);
}
