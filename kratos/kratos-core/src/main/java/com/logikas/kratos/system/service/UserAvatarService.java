package com.logikas.kratos.system.service;

import com.logikas.kratos.core.service.EntityFinder;
import com.logikas.kratos.system.domain.UserAvatar;

import java.io.InputStream;

public interface UserAvatarService extends EntityFinder<UserAvatar, Long> {

  UserAvatar create(String filename, String contentType, InputStream content);
}
