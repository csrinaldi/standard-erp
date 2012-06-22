package com.logikas.kratools.annextract.rebind;


public class ClassInstanceWriter<T> extends ConstantInstanceWriter<Class<T>> {

	public ClassInstanceWriter(Class<Class<T>> type) {
		super(type);
	}
	
	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, Class<T> instance) {
		return instance.getName() + ".class";
	}
}
