package com.logikas.kratos.commons.tuple;

public class Tuples {
  
  <A, B> Pair<A, B> tuple(A a, B b) {
    return new Pair<A, B>(a, b);
  }
}
