package com.logikas.kratos.common.base;

public interface Product extends Iterable<Object> {

  int getArity();

  Object get(int index);
}
