package com.logikas.kratos.common.base;

public class Sextuple<A, B, C, D, E, F> extends AbstractProduct implements Product {

  Sextuple(A a, B b, C c, D d, E e, F f) {
    super(a, b, c, d, e, f);
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

  public E getE() {
    return getMember(4);
  }
  
  public E getF() {
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
