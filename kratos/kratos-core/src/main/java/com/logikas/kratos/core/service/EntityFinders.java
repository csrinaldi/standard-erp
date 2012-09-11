package com.logikas.kratos.core.service;


import com.google.inject.TypeLiteral;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class EntityFinders {

  @SuppressWarnings("unchecked")
  public static <T> Class<T> getDomainType(Class<EntityFinder<T, ?>> finderType) {

    final TypeLiteral<EntityFinder<T, ?>> finderLiteral = TypeLiteral.get(finderType);

    @SuppressWarnings({"rawtypes"})
    final TypeLiteral<EntityFinder<?, ?>> actualFinderLiteral =
        (TypeLiteral) finderLiteral.getSupertype(EntityFinder.class);

    final ParameterizedType actualFinderGeneric = (ParameterizedType) actualFinderLiteral.getType();

    final Type actualDomainType = actualFinderGeneric.getActualTypeArguments()[0];
    
    assert actualDomainType instanceof Class : "Wrong domain type parameter in "
        + finderLiteral.getRawType().getName();

    return (Class<T>) actualDomainType;
  }

  public static <ID extends Serializable> Class<ID> getIdType(Class<EntityFinder<?, ID>> finderType) {

    final TypeLiteral<EntityFinder<?, ID>> finderLiteral = TypeLiteral.get(finderType);

    @SuppressWarnings({"rawtypes", "unchecked"})
    final TypeLiteral<EntityFinder<?, ID>> actualFinderLiteral =
        (TypeLiteral) finderLiteral.getSupertype(EntityFinder.class);

    final ParameterizedType actualFinderGeneric = (ParameterizedType) actualFinderLiteral.getType();

    final Type actualIdType = actualFinderGeneric.getActualTypeArguments()[1];

    assert actualIdType instanceof Class : "Wrong id type parameter in "
        + finderLiteral.getRawType().getName();

    @SuppressWarnings("unchecked")
    final Class<ID> idType = (Class<ID>) actualIdType;

    assert Serializable.class.isAssignableFrom(idType) : "ID type must implement java.io.Serializable in "
        + finderLiteral.getRawType().getName();

    return idType;
  }
}
