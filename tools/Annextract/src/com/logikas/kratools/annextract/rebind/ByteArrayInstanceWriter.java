package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class ByteArrayInstanceWriter extends ArrayInstanceWriter<byte[]> {

	public ByteArrayInstanceWriter() {
		super(byte[].class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, byte[] instance) {

		return writeObjectInstance(fieldWriter, ArrayUtils.toObject(instance));
	}

	@Override
	public CacheHolder<byte[]> createHolder(byte[] instance) {
		return new CacheHolder<byte[]>(instance) {
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
