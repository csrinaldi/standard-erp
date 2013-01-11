package com.logikas.common.repository.jpa;

public interface Transactor {

  interface Execution<T> {

    T execute();
  }
    
  <T> T perform(Execution<T> e);
}
