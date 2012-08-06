package com.logikas.kratos.system.shared.proxy;

import com.logikas.kratos.system.domain.User;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(User.class)
public interface UserProxy extends EntityProxy {
  
  EntityProxyId<UserProxy> stableId();
  
  Long getId();
  
  String getName();
  void setName(String name);
}
