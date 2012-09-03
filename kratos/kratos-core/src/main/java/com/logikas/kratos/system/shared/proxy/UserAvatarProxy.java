package com.logikas.kratos.system.shared.proxy;

import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.locator.UserAvatarLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = UserAvatar.class, locator = UserAvatarLocator.class)
public interface UserAvatarProxy extends EntityProxy {

  EntityProxyId<UserAvatarProxy> stableId();

  Long getId();
}
