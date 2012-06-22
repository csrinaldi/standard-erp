package com.logikas.kratools.annextract.rebind;

public abstract class ArrayInstanceWriter<T> extends AbstractInstanceWriter<T> {

	protected ArrayInstanceWriter(Class<T> type) {
		super(type);
		assert type.isArray() : "type must be an array class";
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String writeObjectInstance(AnnotationExtractorFieldWriter fieldWriter,
			Object[] instance) {

		final StringBuffer output = new StringBuffer();

		output.append(String.format("new %s {", getType().getCanonicalName()));

		boolean hasComma = false;

		for (final Object o : instance) {

			if (hasComma) {

				output.append(",");
			} else {

				hasComma = true;
			}
			output.append(' ');
			output.append(fieldWriter.createField((Class) getType()
					.getComponentType(), o));
		}

		if (instance.length > 0) {
			output.append(" ");
		}

		output.append('}');

		return output.toString();
	}
}
