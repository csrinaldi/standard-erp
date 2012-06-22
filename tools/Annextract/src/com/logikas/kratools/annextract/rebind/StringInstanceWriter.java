package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.StringEscapeUtils;

public class StringInstanceWriter extends ConstantInstanceWriter<String> {

	public StringInstanceWriter() {
		super(String.class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, String instance) {
		
		return "\"" + StringEscapeUtils.escapeJava(instance) + "\"";
	}
}
