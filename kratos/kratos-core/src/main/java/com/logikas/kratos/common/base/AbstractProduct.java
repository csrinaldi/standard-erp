package com.logikas.kratos.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;

import java.util.Arrays;
import java.util.Iterator;

public abstract class AbstractProduct implements Product {

  private static final Joiner JOINER = Joiner.on(", ");

  protected final Object[] members;

  protected AbstractProduct(Object... members) {
    this.members = members;
  }

  @Override
  public int getArity() {
    return members.length;
  }

  @SuppressWarnings("unchecked")
  protected <T> T getMember(int index) {
    return (T) get(index);
  }

  @Override
  public Object get(int index) {
    return members[index];
  }

  @Override
  public Iterator<Object> iterator() {
    return Arrays.asList(members).iterator();
  }

  protected boolean equalMembers(Product other) {
    for (int i = 0; i < getArity(); i++) {
      if (!Objects.equal(get(i), other.get(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(members);
  }

  public String toString() {
    return "(" + JOINER.join(members) + ")";
  }
}
