package com.logikas.common.repository;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;

public class Repositories {

  private Repositories() {
  }

  public static <T> Class<T> entityType(Class<? extends Repository<T, ?>> repositoryType) {

    @SuppressWarnings("unchecked")
    final TypeToken<Repository<T, ?>> token =
        (TypeToken<Repository<T, ?>>) TypeToken.of(repositoryType).getSupertype(Repository.class);
    final ParameterizedType paramType = (ParameterizedType) token.getType();
    @SuppressWarnings("unchecked")
    final Class<T> entityType = (Class<T>) paramType.getActualTypeArguments()[0];
    return entityType;
  }
}
