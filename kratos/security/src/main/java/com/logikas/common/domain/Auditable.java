package com.logikas.common.domain;

import java.util.Date;

import com.logikas.core.security.persistence.User;

public interface Auditable {

  User getCreatedBy();

  void setCreatedBy(User createdBy);

  Date getCreated();

  void setCreated(Date creationDate);

  User getLastModifiedBy();

  void setLastModifiedBy(User lastModifiedBy);

  Date getLastModified();

  void setLastModified(Date lastModifiedDate);
}
