package com.logikas.kratos.system.shared.factory;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface SystemRequestFactory extends RequestFactory {
  
  UserServiceRequestContext createUserService();  
}
