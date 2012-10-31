package com.logikas.kratos.core.ioc;

import com.logikas.kratos.core.facade.KratosRequestFactoryServlet;
import com.logikas.kratos.core.facade.UserAvatarServlet;
import com.logikas.kratos.core.ioc.validation.ValidationModule;
import com.logikas.kratos.core.repository.EntityAccessorFactory;
import com.logikas.kratos.core.repository.jpa.EventBusEntityListener;
import com.logikas.kratos.core.repository.jpa.JpaEntityAccessorFactory;
import com.logikas.kratos.security.ioc.SecurityMainModule;
import com.logikas.kratos.system.ioc.SystemModule;

import com.google.inject.Provides;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;

import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class KratosServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    
    //install(new AutodiscoveredEntityFinderModule());

    bind(ExceptionHandler.class).to(DefaultExceptionHandler.class).in(Singleton.class);
    bind(EntityAccessorFactory.class).to(JpaEntityAccessorFactory.class).in(Singleton.class);

    serve("/gwtRequest").with(KratosRequestFactoryServlet.class);

    install(new SystemModule());
    install(new ValidationModule());

    // TODO ver si esta dependencia la podemos sacar de aca
    install(new SecurityMainModule(this.getServletContext()));

    install(new JpaPersistModule("Kratos"));
    filter("/*").through(PersistFilter.class);

    final UserAvatarServlet userAvatarServlet = new UserAvatarServlet();

    requestInjection(userAvatarServlet);

    final ServletRegistration.Dynamic registration =
        getServletContext().addServlet("userAvatarServlet", userAvatarServlet);

    registration.addMapping("/resources");
    registration.setMultipartConfig(new MultipartConfigElement(""));
  
    requestStaticInjection(EventBusEntityListener.class);
    
    //serve("/resources").with(UserAvatarServlet.class);
  }

  @Provides
  @Singleton
  Metamodel getMetamodel(EntityManagerFactory factory) {
    return factory.getMetamodel();
  }
}
