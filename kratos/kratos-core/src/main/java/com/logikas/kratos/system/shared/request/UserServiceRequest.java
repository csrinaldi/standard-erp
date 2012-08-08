package com.logikas.kratos.system.shared.request;

import com.logikas.kratos.core.facade.KratosServiceLocator;
import com.logikas.kratos.system.service.UserService;
import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = UserService.class, locator = KratosServiceLocator.class)
public interface UserServiceRequest extends RequestContext {

  Request<UserProxy> find(Long id);

  Request<Void> save(UserProxy proxy);
}
