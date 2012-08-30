package com.logikas.kratos.common.base;

public class Quintuple<A, B, C, D, E> extends AbstractProduct implements Product {

  Quintuple(A a, B b, C c, D d, E e) {
    super(a, b, c, d, e);
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

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Quintuple<?, ?, ?, ?, ?>)) {
      return false;
    }
    Quintuple<?, ?, ?, ?, ?> other = (Quintuple<?, ?, ?, ?, ?>) o;
    return equalMembers(other);
  }
}
