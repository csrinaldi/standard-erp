package com.logikas.common.tuples;

public class Simple<M0> extends AbstractProduct implements Product {

  Simple(M0 m0) {
    super(m0);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Simple<?>)) {
      return false;
    }
    Simple<?> other = (Simple<?>) o;
    return equalMembers(other);
  }

  public M0 getM0() {
    return getMember(0);
  }
}
