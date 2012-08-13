package com.logikas.kratos.core.repository;

public interface EntityFinder<T, I> {
  
  T find(I id);
}
