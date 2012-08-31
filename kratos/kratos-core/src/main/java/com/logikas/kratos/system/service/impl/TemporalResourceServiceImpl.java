package com.logikas.kratos.system.service.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.repository.DocumentRepository;
import com.logikas.kratos.system.service.UserAvatarService;

import java.io.InputStream;
import java.util.Date;

import javax.inject.Provider;

public class TemporalResourceServiceImpl implements UserAvatarService {

  private final DocumentRepository repository;

  private final Provider<Date> now;

  private final Provider<User> user;

  public TemporalResourceServiceImpl(DocumentRepository repository, Provider<Date> now,
      Provider<User> user) {
    this.repository = repository;
    this.now = now;
    this.user = user;
  }

  @Override
  public UserAvatar findOne(Long primaryKey) {
    return repository.findOne(primaryKey);
  }

  @Override
  public UserAvatar create(String filename, String contentType, InputStream content) {
    final UserAvatar avatar = new UserAvatar();
    avatar.setFilename(filename);
    avatar.setContentType(contentType);
    avatar.setOwner(user.get());
    avatar.setCreated(now.get());
    repository.save(avatar);
    return avatar;
  }
}
