package com.logikas.common.tuples;

public class Triple<M0, M1, M2> extends AbstractProduct implements Product {

  Triple(M0 m0, M1 m1, M2 m2) {
    super(m0, m1, m2);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Triple<?, ?, ?>)) {
      return false;
    }
    Triple<?, ?, ?> other = (Triple<?, ?, ?>) o;
    return equalMembers(other);
  }

  public M0 getM0() {
    return getMember(0);
  }

  public M1 getM1() {
    return getMember(1);
  }

  public M2 getM2() {
    return getMember(2);
  }
}
