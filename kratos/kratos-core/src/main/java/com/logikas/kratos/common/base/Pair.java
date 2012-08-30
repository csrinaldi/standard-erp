package com.logikas.kratos.common.base;

public class Pair<A, B> extends AbstractProduct implements Product {

  Pair(A a, B b) {
    super(a, b);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair<?, ?>)) {
      return false;
    }
    Pair<?, ?> other = (Pair<?, ?>) o;
    return equalMembers(other);
  }

  public A getA() {
    return getMember(0);
  }

  public B getB() {
    return getMember(1);
  }
}
