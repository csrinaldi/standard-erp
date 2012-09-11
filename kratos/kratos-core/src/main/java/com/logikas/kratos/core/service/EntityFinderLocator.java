package com.logikas.kratos.core.service;


public interface EntityFinderLocator {
  
  <T> EntityFinder<T, ?> get(Class<T> domainType);
}
