package com.logikas.kratos.system.repository;

import com.logikas.kratos.system.domain.User;

public interface UserRepository {

  User find(Long id);
}
