package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class FloatArrayInstanceWriter extends ArrayInstanceWriter<float[]> {

	public FloatArrayInstanceWriter() {
		super(float[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, float[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<float[]> createHolder(float[] instance) {
		return new CacheHolder<float[]>(instance) {
			
			@Override
			public boolean equals(Object obj) {
				return Arrays.equals(getInstance(), getHeldInstance(obj));
			}

			@Override
			public int hashCode() {
				return Arrays.hashCode(getInstance());
			}
		};
	}
}
