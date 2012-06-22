package com.logikas.kratools.annextract.rebind;

public abstract class CacheHolder<T> {
	
	private final T instance;
	
	protected CacheHolder(T instance) {
		this.instance = instance;
	}
	
	public T getInstance() {
		return instance;
	}
	
	public abstract boolean equals(Object obj);

	public abstract int hashCode();
}
