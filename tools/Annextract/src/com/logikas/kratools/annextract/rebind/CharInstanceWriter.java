package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.CharUtils;


public class CharInstanceWriter extends ConstantInstanceWriter<Character> {

	public CharInstanceWriter() {
		super(char.class);
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, Character instance) {
		
		return String.format("'%s'", CharUtils.unicodeEscaped(instance));
	}
}
