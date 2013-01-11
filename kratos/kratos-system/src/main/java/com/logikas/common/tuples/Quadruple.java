package com.logikas.common.tuples;

public class Quadruple<M0, M1, M2, M3> extends AbstractProduct implements Product {

  Quadruple(M0 m0, M1 m1, M2 m2, M3 m3) {
    super(m0, m1, m2, m3);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Quadruple<?, ?, ?, ?>)) {
      return false;
    }
    Quadruple<?, ?, ?, ?> other = (Quadruple<?, ?, ?, ?>) o;
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

  public M3 getM3() {
    return getMember(3);
  }
}
