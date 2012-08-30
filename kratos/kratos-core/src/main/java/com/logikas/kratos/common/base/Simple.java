package com.logikas.kratos.common.base;

public class Simple<A> extends AbstractProduct implements Product {

  Simple(A a) {
    super(a);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Simple<?>)) {
      return false;
    }
    Simple<?> other = (Simple<?>) o;
    return equalMembers(other);
  }

  public A getA() {
    return getMember(0);
  }
}
