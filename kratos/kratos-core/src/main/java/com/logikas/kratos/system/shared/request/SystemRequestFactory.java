package com.logikas.kratos.system.shared.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface SystemRequestFactory extends RequestFactory {
  
  UserServiceRequest createUserService();  
}
