package com.logikas.common.tuples;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public class Tuples {

  private static final Unit UNIT = new Unit();

  public static Unit unit() {
    return UNIT;
  }

  public static Unit tuple() {
    return unit();
  }

  public static <A> Simple<A> tuple(A a) {
    return new Simple<A>(a);
  }

  public static <A, B> Pair<A, B> tuple(A a, B b) {
    return new Pair<A, B>(a, b);
  }

  public static <A, B, C> Triple<A, B, C> tuple(A a, B b, C c) {
    return new Triple<A, B, C>(a, b, c);
  }

  public static <A, B, C, D> Quadruple<A, B, C, D> tuple(A a, B b, C c, D d) {
    return new Quadruple<A, B, C, D>(a, b, c, d);
  }

  public static <A, B, C, D, E> Quintuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
    return new Quintuple<A, B, C, D, E>(a, b, c, d, e);
  }

  public static <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F> tuple(A a, B b, C c, D d, E e, F f) {
    return new Sextuple<A, B, C, D, E, F>(a, b, c, d, e, f);
  }

  @SuppressWarnings({"unchecked"})
  public static <T> Iterable<T> lowerBound(Simple<T> simple) {
    return (Iterable<T>) simple;
  }

  @SuppressWarnings({"unchecked"})
  public static <T, A extends T, B extends T> Iterable<T> lowerBound(Pair<A, B> pair) {
    return (Iterable<T>) pair;
  }

  @SuppressWarnings({"unchecked"})
  public static <T, A extends T, B extends T, C extends T> Iterable<T> lowerBound(
      Triple<A, B, C> triple) {
    return (Iterable<T>) triple;
  }

  @SuppressWarnings({"unchecked"})
  public static <T, A extends T, B extends T, C extends T, D extends T> Iterable<T> lowerBound(
      Quadruple<A, B, C, D> quadruple) {
    return (Iterable<T>) quadruple;
  }

  @SuppressWarnings({"unchecked"})
  public static <T, A extends T, B extends T, C extends T, D extends T, E extends T> Iterable<T> lowerBound(
      Quintuple<A, B, C, D, E> quintuple) {
    return (Iterable<T>) quintuple;
  }

  @SuppressWarnings({"unchecked"})
  public static <T, A extends T, B extends T, C extends T, D extends T, E extends T, F extends T> Iterable<T> lowerBound(
      Sextuple<A, B, C, D, E, F> sextuple) {
    return (Iterable<T>) sextuple;
  }

  public static Function<Integer, Object> asFunction(final Product product) {

    return new Function<Integer, Object>() {
      @Override
      public Object apply(Integer input) {
        return product.get(input);
      }
    };
  }

  public static Object tuplize(Object[] array) {

    Preconditions.checkArgument(array.length <= 6, "length can't be greater than 6");

    switch (array.length) {
      case 0:
        return null;

      case 1:
        return array[0];

      case 2:
        return tuple(array[0], array[1]);

      case 3:
        return tuple(array[0], array[1], array[2]);

      case 4:
        return tuple(array[0], array[1], array[2], array[3]);

      case 5:
        return tuple(array[0], array[1], array[2], array[3], array[4]);

      case 6:
        return tuple(array[0], array[1], array[2], array[3], array[0], array[1]);

      default:
        return null;
    }

  }

  public static Function<Object[], Object> arrayTuplizer() {
    
    return new Function<Object[], Object>() {
      public Object apply(Object[] array) {
        return tuplize(array);
      }
    };
  }
}
