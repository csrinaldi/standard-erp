package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class CharArrayInstanceWriter extends ArrayInstanceWriter<char[]> {

	public CharArrayInstanceWriter() {
		super(char[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, char[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<char[]> createHolder(char[] instance) {
		return new CacheHolder<char[]>(instance) {
		
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
