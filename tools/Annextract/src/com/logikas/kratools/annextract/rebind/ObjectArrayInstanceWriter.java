package com.logikas.kratools.annextract.rebind;

import java.util.Arrays;

public class ObjectArrayInstanceWriter<T> extends ArrayInstanceWriter<T[]> {

	public ObjectArrayInstanceWriter(Class<T[]> type) {
		super(type);
	}

	public CacheHolder<T[]> createHolder(T[] instance) {

		return new CacheHolder<T[]>(instance) {
			
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

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, T[] instance) {
		return writeObjectInstance(fieldWriter, instance);
	}
}
