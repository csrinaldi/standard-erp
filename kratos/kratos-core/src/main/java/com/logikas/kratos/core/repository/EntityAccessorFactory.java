package com.logikas.kratos.core.repository;

public interface EntityAccessorFactory {

  <T, I> EntityAccessor<T, I> createAccessor(Class<T> domainType, Class<I> idType);
}
