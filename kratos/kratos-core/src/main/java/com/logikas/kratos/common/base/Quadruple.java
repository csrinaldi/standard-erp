package com.logikas.kratos.common.base;


public class Quadruple<A, B, C, D> extends AbstractProduct implements Product {

  Quadruple(A a, B b, C c, D d) {
    super(a, b, c, d);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Quadruple<?, ?, ?, ?>)) {
      return false;
    }
    Quadruple<?, ?, ?, ?> other = (Quadruple<?, ?, ?, ?>) o;
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

  public D getD() {
    return getMember(3);
  }
}
