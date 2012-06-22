package com.logikas.kratools.annextract.rebind;

import com.google.gwt.user.rebind.SourceWriter;

import java.util.HashMap;
import java.util.Map;

public class AnnotationExtractorFieldWriter {

	private final Map<Class<?>, InstanceWriter<?>> instanceWriters;
	private final Map<CacheHolder<?>, String> cachedInstances;

	private int fieldCount = 0;
	
	private final SourceWriter sourceWriter;

	private final AnnotationImplementor annotationImplementor;

	public AnnotationExtractorFieldWriter(SourceWriter sourceWriter,
			AnnotationImplementor annotationImplementor) {
		this.sourceWriter = sourceWriter;
		this.annotationImplementor = annotationImplementor;
		this.instanceWriters = new HashMap<Class<?>, InstanceWriter<?>>();
		this.cachedInstances = new HashMap<CacheHolder<?>, String>();
	}

	public void initialize() {

		clear();

		// Primitives
		addConstantWriter(byte.class);
		addConstantWriter(short.class);
		addConstantWriter(int.class);
		addConstantWriter(long.class);

		// Primitive float
		addInstanceWriter(new FloatInstanceWriter());

		addConstantWriter(double.class);
		addConstantWriter(boolean.class);

		// Primitive Char
		addInstanceWriter(new CharInstanceWriter());

		// Primitive Arrays
		addInstanceWriter(new ByteArrayInstanceWriter());
		addInstanceWriter(new ShortArrayInstanceWriter());
		addInstanceWriter(new IntArrayInstanceWriter());
		addInstanceWriter(new LongArrayInstanceWriter());
		addInstanceWriter(new FloatArrayInstanceWriter());
		addInstanceWriter(new DoubleArrayInstanceWriter());
		addInstanceWriter(new BooleanArrayInstanceWriter());
		addInstanceWriter(new CharArrayInstanceWriter());

		// String
		addInstanceWriter(new StringInstanceWriter());
	}

	public void clear() {
		cachedInstances.clear();
		instanceWriters.clear();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addConstantWriter(Class<?> type) {
		instanceWriters.put(type, new ConstantInstanceWriter(type));
	}

	private void addInstanceWriter(InstanceWriter<?> writer) {
		instanceWriters.put(writer.getType(), writer);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> InstanceWriter<T> getInstanceWriter(Class<? extends T> type) {

		InstanceWriter cachedWriter = instanceWriters.get(type);

		if (cachedWriter == null) {

			if (type.isArray()) {
				cachedWriter = new ObjectArrayInstanceWriter(type);
			} else if (type.isAnnotation()) {
				cachedWriter = new AnnotationInstanceWriter(type,
						annotationImplementor);
			} else if (type.isEnum()) {
				cachedWriter = new EnumInstanceWriter(type);
			} else if (type.isAssignableFrom(Class.class)) {
				cachedWriter = new ClassInstanceWriter(type);
			} else {
				return null;
			}
			addInstanceWriter(cachedWriter);

		}
		return cachedWriter;
	}

	public <T> String createField(Class<T> type, T instance) {

		if (instance == null) {
			return "null";
		}

		final InstanceWriter<T> instanceWriter = getInstanceWriter(type);
		
		assert instanceWriter != null: "Unsupported type: " + type.getCanonicalName();

		final String instantiation = instanceWriter.writeInstance(this,
				instance);

		if (instanceWriter.isConstant()) {
			return instantiation;
		}

		final CacheHolder<T> holder = instanceWriter
				.createHolder(instance);

		final String cached = cachedInstances.get(holder);

		if (cached != null) {

			return cached;
		}

		final String fieldName = String.format("_instance_%d_", fieldCount++);

		final String typeName = type.getCanonicalName();

		sourceWriter.println();
		sourceWriter.println("private final %s %s = %s;", typeName, fieldName,
				instantiation);

		cachedInstances.put(holder, fieldName);

		return fieldName;
	}
}
