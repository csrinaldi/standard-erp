package com.logikas.kratos.system.shared.proxy;

import com.logikas.kratos.core.locator.GenericEntityLocator;
import com.logikas.kratos.system.domain.User;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = User.class, locator = GenericEntityLocator.class) // , locator = UserLocator.class)
public interface UserProxy extends EntityProxy {

  EntityProxyId<UserProxy> stableId();

  Long getId();

  String getName();

  void setName(String name);
}
