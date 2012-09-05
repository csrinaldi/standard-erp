package com.logikas.kratos.system.service.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.repository.UserAvatarRepository;
import com.logikas.kratos.system.service.UserAvatarService;

import java.io.InputStream;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Provider;

public class UserAvatarServiceImpl implements UserAvatarService {

  private final UserAvatarRepository repository;

  private final Provider<Date> now;

  private final Provider<User> user;

  @Inject
  UserAvatarServiceImpl(UserAvatarRepository repository, Provider<Date> now, Provider<User> user) {
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