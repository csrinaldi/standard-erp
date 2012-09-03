package com.logikas.kratos.system.ioc;

import java.util.Date;

import javax.inject.Provider;

public class DateProvider implements Provider<Date> {

  @Override
  public Date get() {
    return new Date();
  }
}
