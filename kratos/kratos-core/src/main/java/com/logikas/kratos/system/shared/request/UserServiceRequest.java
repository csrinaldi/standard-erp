package com.logikas.kratos.system.shared.request;

import com.logikas.kratos.core.locator.GenericServiceLocator;
import com.logikas.kratos.system.service.UserService;
import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.List;

@Service(value = UserService.class, locator = GenericServiceLocator.class)
public interface UserServiceRequest extends RequestContext {

  Request<UserProxy> find(Long id);

  Request<Void> save(UserProxy proxy);

  Request<List<UserProxy>> findByName(String name, int start, int rows);

  Request<List<UserProxy>> findAll(int start, int length);
}
