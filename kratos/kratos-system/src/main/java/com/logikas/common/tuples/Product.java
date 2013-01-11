package com.logikas.common.tuples;

public interface Product extends Iterable<Object> {

  int getArity();

  Object get(int index);
}
