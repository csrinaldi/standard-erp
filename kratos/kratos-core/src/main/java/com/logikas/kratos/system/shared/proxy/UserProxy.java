package com.logikas.kratos.system.shared.proxy;

import com.logikas.kratos.system.domain.User;

import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(User.class)
public interface UserProxy {
  
  Long getId();
  
  String getName();
  void setName(String name);
}
