package com.logikas.common.auditory.guice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class PropertyAttributeAccessor<E, T> implements AttributeAccessor<E, T> {

  private final String name;

  private final Method getter;

  private final Method setter;

  PropertyAttributeAccessor(String name, Method getter, Method setter) {
    this.name = name;
    this.getter = getter;
    this.setter = setter;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Member getMember() {
    return getter;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T getValue(E entity) throws Throwable {
    try {
      return (T) getter.invoke(entity);
    } catch (InvocationTargetException e) {
      throw e.getCause();
    }
  }

  @Override
  public void setValue(E entity, T value) throws Throwable {
    try {
      setter.invoke(entity, value);
    } catch (InvocationTargetException e) {
      throw e.getCause();
    }
  }

  private static final String GETTER_PREFFIX = "get";

  private static final String SETTER_PREFFIX = "set";

  private static String capitalizedName(String getterName) {
    return !getterName.startsWith(GETTER_PREFFIX) ? "" : getterName.substring(GETTER_PREFFIX
        .length());
  }

  private static String uncapitalized(String capitalized) {
    return Character.toLowerCase(capitalized.charAt(0)) + capitalized.substring(1);
  }

  public static <E, T> AttributeAccessor<E, T> tryCreate(Method getter) {

    if (void.class.equals(getter.getReturnType()) || getter.getParameterTypes().length > 0) {
      return null;
    }

    final String capitalizedName = capitalizedName(getter.getName());

    if (capitalizedName.isEmpty()) {
      return null;
    }

    // if (!getter.isAccessible()) {
    // throw new IllegalArgumentException("Not accessible getter '" + getter.getName()
    // + "' in class " + getter.getDeclaringClass().getName());
    // }

    final String setterName = SETTER_PREFFIX + capitalizedName;

    final Method setter;

    try {
      setter = getter.getDeclaringClass().getMethod(setterName, getter.getReturnType());
    } catch (Exception e) {
      return null;
    }

    // Se permiten setters con retorno diferente de void
    // if (!setter.isAccessible()) {
    // throw new IllegalArgumentException("Not accessible setter '" + setter.getName()
    // + "' for getter '" + getter.getName() + "' in class "
    // + getter.getDeclaringClass().getName());
    // }

    return new PropertyAttributeAccessor<E, T>(uncapitalized(capitalizedName), getter, setter);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<? extends T> getValueType() {
    return (Class<? extends T>) getter.getReturnType();
  }
}
