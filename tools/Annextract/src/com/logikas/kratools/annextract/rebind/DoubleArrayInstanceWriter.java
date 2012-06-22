package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class DoubleArrayInstanceWriter extends ArrayInstanceWriter<double[]> {

	public DoubleArrayInstanceWriter() {
		super(double[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, double[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<double[]> createHolder(double[] instance) {
		return new CacheHolder<double[]>(instance) {
			
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
