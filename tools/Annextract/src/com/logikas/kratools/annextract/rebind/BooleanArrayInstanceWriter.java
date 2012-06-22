package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class BooleanArrayInstanceWriter extends ArrayInstanceWriter<boolean[]> {

	public BooleanArrayInstanceWriter() {
		super(boolean[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter,
			boolean[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<boolean[]> createHolder(boolean[] instance) {

		return new CacheHolder<boolean[]>(instance) {

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
