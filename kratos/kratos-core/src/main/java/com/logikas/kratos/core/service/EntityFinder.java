package com.logikas.kratos.core.service;

import java.io.Serializable;

public interface EntityFinder<T, ID extends Serializable> {

  T find(ID primaryKey);
}
