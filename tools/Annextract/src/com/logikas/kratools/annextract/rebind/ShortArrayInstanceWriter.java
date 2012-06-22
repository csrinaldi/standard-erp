package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class ShortArrayInstanceWriter extends ArrayInstanceWriter<short[]> {

	public ShortArrayInstanceWriter() {
		super(short[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, short[] instance) {
		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<short[]> createHolder(short[] instance) {
		
		return new CacheHolder<short[]>(instance) {
			
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
