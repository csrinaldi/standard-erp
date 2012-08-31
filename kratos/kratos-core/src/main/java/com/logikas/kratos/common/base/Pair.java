package com.logikas.kratos.common.base;

public class Pair<M0, M1> extends AbstractProduct implements Product {

  Pair(M0 m0, M1 m1) {
    super(m0, m1);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair<?, ?>)) {
      return false;
    }
    Pair<?, ?> other = (Pair<?, ?>) o;
    return equalMembers(other);
  }

  public M0 getM0() {
    return getMember(0);
  }

  public M1 getM1() {
    return getMember(1);
  }
}
