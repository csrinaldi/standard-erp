package com.logikas.system.repository.impl;

import static com.logikas.system.domain.QSystemUser.systemUser;

import com.logikas.common.repository.jpa.JpaRepository;
import com.logikas.system.domain.SystemUser;
import com.logikas.system.repository.SystemUserRepository;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
public class SystemUserRepositoryImpl extends JpaRepository<SystemUser, Long> implements SystemUserRepository {

  @Override
  public SystemUser findByName(String name) {
    return from(systemUser).where(systemUser.name.eq(name)).uniqueResult(systemUser);
  }
}
