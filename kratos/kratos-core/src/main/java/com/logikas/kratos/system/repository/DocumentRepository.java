package com.logikas.kratos.system.repository;

import com.logikas.kratos.core.repository.Repository;
import com.logikas.kratos.system.domain.UserAvatar;

import com.google.inject.servlet.RequestScoped;
@RequestScoped
public interface DocumentRepository extends Repository<UserAvatar, Long> {

}
