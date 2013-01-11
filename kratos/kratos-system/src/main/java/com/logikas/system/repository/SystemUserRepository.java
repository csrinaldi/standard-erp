package com.logikas.system.repository;

import com.logikas.common.repository.Repository;
import com.logikas.system.domain.SystemUser;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public interface SystemUserRepository extends Repository<SystemUser, Long> {

  SystemUser findByName(String nombre);
}
