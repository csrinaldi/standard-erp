package com.logikas.kratools.annextract.rebind;


public interface InstanceWriter<T> {
		
	CacheHolder<T> createHolder(T instance);

	Class<T> getType();
	
	String writeInstance(AnnotationExtractorFieldWriter fieldWriter, T instance);
	
	boolean isConstant();
}
