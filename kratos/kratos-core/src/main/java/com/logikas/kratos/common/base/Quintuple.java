package com.logikas.kratos.common.base;

public class Quintuple<M0, M1, M2, M3, M4> extends AbstractProduct implements Product {

  Quintuple(M0 m0, M1 m1, M2 m2, M3 m3, M4 m4) {
    super(m0, m1, m2, m3, m4);
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

  public M3 getM3() {
    return getMember(3);
  }

  public M4 getM4() {
    return getMember(4);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Quintuple<?, ?, ?, ?, ?>)) {
      return false;
    }
    Quintuple<?, ?, ?, ?, ?> other = (Quintuple<?, ?, ?, ?, ?>) o;
    return equalMembers(other);
  }
}
