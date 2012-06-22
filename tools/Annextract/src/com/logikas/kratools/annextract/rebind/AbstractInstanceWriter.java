package com.logikas.kratools.annextract.rebind;

public abstract class AbstractInstanceWriter<T> implements InstanceWriter<T> {

  private final Class<T> type;

  public AbstractInstanceWriter(Class<T> type) {
    this.type = type;
  }

  @SuppressWarnings("unchecked")
  protected T getHeldInstance(Object obj) {

    if (!(obj instanceof CacheHolder)) {
      return null;
    }

    @SuppressWarnings("rawtypes")
    final CacheHolder holder = (CacheHolder) obj;

    if (getType().isAssignableFrom(holder.getInstance().getClass())) {
      return (T) holder.getInstance();
    }

    return null;
  }

  public CacheHolder<T> createHolder(T instance) {

    return new CacheHolder<T>(instance) {

      @Override
      public boolean equals(Object obj) {
        return getInstance().equals(getHeldInstance(obj));
      }

      @Override
      public int hashCode() {
        return getInstance().hashCode();
      }
    };
  }

  @Override
  public Class<T> getType() {
    return type;
  }
}
