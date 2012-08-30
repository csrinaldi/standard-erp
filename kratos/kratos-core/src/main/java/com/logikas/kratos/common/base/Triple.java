package com.logikas.kratos.common.base;

public class Triple<A, B, C> extends AbstractProduct implements Product {

  Triple(A a, B b, C c) {
    super(a, b, c);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Triple<?, ?, ?>)) {
      return false;
    }
    Triple<?, ?, ?> other = (Triple<?, ?, ?>) o;
    return equalMembers(other);
  }

  public A getA() {
    return getMember(0);
  }

  public B getB() {
    return getMember(1);
  }

  public C getC() {
    return getMember(2);
  }
}
