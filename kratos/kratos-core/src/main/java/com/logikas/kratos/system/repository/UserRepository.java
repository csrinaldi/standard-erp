package com.logikas.kratos.system.repository;

import com.logikas.kratos.core.repository.Repository;
import com.logikas.kratos.system.domain.User;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {
  
  List<User> findByName(String name, int start, int rows);

  List<User> findAll(int start, int rows);

}
