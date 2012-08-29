package com.logikas.kratos.system.service.impl;

import com.logikas.kratos.system.domain.TemporalResource;
import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.TemporalResourceRepository;
import com.logikas.kratos.system.service.TemporalResourceService;

import com.google.inject.persist.Transactional;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Provider;

public class TemporalResourceServiceImpl implements TemporalResourceService {

  private final TemporalResourceRepository repository;

  private final Provider<Date> now;
  
  private final Provider<User> user;

  @Inject
  TemporalResourceServiceImpl(TemporalResourceRepository repository, Provider<Date> now, Provider<User> user) {
    this.repository = repository;
    this.now = now;
    this.user = user;
  }

  @Transactional
  @Override
  public Long create(String filename, String contentType, InputStream content) {
    final TemporalResource temp = new TemporalResource();
    temp.setCreated(now.get());
    temp.setOwner(user.get());
    temp.setFilename(filename);
    temp.setContentType(contentType);
    temp.setContent(null);
    repository.save(temp);
    return temp.getId();
  }

  @Override
  public InputStream getStream(Long id) {
    try {
      return repository.findOne(id).getContent().getBinaryStream();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Date getCreated(Long id) {
    return repository.findOne(id).getCreated();
  }

  @Override
  public String getSessionId(Long id) {
    return null;
  }
}
