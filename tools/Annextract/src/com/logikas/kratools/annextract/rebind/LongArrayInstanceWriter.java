package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class LongArrayInstanceWriter extends ArrayInstanceWriter<long[]> {

	public LongArrayInstanceWriter() {
		super(long[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, long[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<long[]> createHolder(long[] instance) {
		return new CacheHolder<long[]>(instance) {
			
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
