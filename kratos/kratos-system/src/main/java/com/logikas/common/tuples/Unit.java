package com.logikas.common.tuples;

public class Unit extends AbstractProduct implements Product {

  @Override
  public boolean equals(Object o) {
    return o instanceof Unit;
  }
}
