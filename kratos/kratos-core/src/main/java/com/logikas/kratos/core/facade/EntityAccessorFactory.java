package com.logikas.kratos.core.facade;

import com.logikas.kratos.core.repository.EntityAccessor;

public interface EntityAccessorFactory {

  <T, I> EntityAccessor<T, I> createAccessor(Class<T> domainType, Class<I> idType);
}
