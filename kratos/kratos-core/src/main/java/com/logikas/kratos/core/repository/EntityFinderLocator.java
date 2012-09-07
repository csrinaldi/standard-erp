package com.logikas.kratos.core.repository;

public interface EntityFinderLocator {
  
  <T> EntityFinder<T, ?> get(Class<T> domainType);
}
