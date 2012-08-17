package com.logikas.kratos.system.repository;

import com.logikas.kratos.core.repository.Repository;
import com.logikas.kratos.system.domain.User;

public interface UserRepository extends Repository<User, Long> {
  
  Iterable<User> findByName(String name);

}
