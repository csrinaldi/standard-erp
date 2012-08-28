package com.logikas.kratos.commons.base;

public class Pair<A, B> implements Product {
  
  private final A a;
  private final B b;

  public Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }
  
  @Override
  public int getArity() {
    return 2;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair<?, ?>)) {
      return false;
    }
    Pair<?, ?> other = (Pair<?, ?>) o;
    return a.equals(other.a) && b.equals(other.b);
  }

  public A getA() {
    return a;
  }

  public B getB() {
    return b;
  }

  @Override
  public int hashCode() {
    return a.hashCode() * 13 + b.hashCode() * 7;
  }
  
  @Override
  public Object get(int index) {
    return index == 0? a: b;
  }
}
