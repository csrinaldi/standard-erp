package com.logikas.kratools.annextract.rebind;

public class ConstantInstanceWriter<T> extends AbstractInstanceWriter<T> {
	
	public ConstantInstanceWriter(Class<T> type) {
		super(type);
	}

	@Override
	public boolean isConstant() {
		return true;
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, T instance) {
		return instance.toString();
	}
}
