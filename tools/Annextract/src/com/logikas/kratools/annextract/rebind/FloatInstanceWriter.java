package com.logikas.kratools.annextract.rebind;



public class FloatInstanceWriter extends ConstantInstanceWriter<Float> {

	public FloatInstanceWriter() {
		super(float.class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, Float instance) {
		
		return String.format("%df", instance);
	}
}
