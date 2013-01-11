package com.logikas.common.tuples;

public class Sextuple<M0, M1, M2, M3, M4, M5> extends AbstractProduct implements Product {

  Sextuple(M0 m0, M1 m1, M2 m2, M3 m3, M4 m4, M5 m5) {
    super(m0, m1, m2, m3, m4, m5);
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

  public M5 getM5() {
    return getMember(5);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Sextuple<?, ?, ?, ?, ?, ?>)) {
      return false;
    }
    Sextuple<?, ?, ?, ?, ?, ?> other = (Sextuple<?, ?, ?, ?, ?, ?>) o;
    return equalMembers(other);
  }
}
