package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class IntArrayInstanceWriter extends ArrayInstanceWriter<int[]> {

	public IntArrayInstanceWriter() {
		super(int[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, int[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<int[]> createHolder(int[] instance) {

		return new CacheHolder<int[]>(instance) {

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
