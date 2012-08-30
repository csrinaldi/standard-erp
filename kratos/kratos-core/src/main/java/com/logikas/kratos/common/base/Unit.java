package com.logikas.kratos.common.base;

public class Unit extends AbstractProduct implements Product {

  @Override
  public boolean equals(Object o) {
    return o instanceof Unit;
  }
}
