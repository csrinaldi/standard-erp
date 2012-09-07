package com.logikas.kratos.core.repository;

import java.io.Serializable;

public interface EntityFinder<T, ID extends Serializable> {

  T find(ID primaryKey);
}
