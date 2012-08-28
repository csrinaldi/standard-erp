package com.logikas.kratos.commons.base;

public class Tuples {
  
  <A, B> Pair<A, B> tuple(A a, B b) {
    return new Pair<A, B>(a, b);
  }
}
