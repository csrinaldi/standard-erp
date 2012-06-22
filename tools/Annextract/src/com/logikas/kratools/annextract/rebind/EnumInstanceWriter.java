package com.logikas.kratools.annextract.rebind;

public class EnumInstanceWriter<E extends Enum<E>> extends ConstantInstanceWriter<E>{
	
	public EnumInstanceWriter(Class<E> type) {
		super(type);
	}
		
	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, E instance) {
		
		return String.format("%s.%s", instance.getDeclaringClass().getCanonicalName(), instance);
	}
}
