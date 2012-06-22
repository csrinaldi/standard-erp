package com.logikas.kratools.annextract.rebind;

import org.apache.commons.lang.StringEscapeUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;


public class AnnotationInstanceWriter<T extends Annotation> extends AbstractInstanceWriter<T> {

	private final AnnotationImplementor annotationImplementor;
	
	private List<Method> collectedMethods = null;
	
	public AnnotationInstanceWriter(Class<T> type, AnnotationImplementor annotationImplementor) {
		super(type);
		this.annotationImplementor = annotationImplementor;
	}
	
	@Override
	public boolean isConstant() {
		return false;
	}
	
	protected List<Method> getCollectedMethods() {
		if(collectedMethods == null) {
			collectedMethods = annotationImplementor.collectMethods(getType());
		}
		return collectedMethods;
	}

	@Override
	public String writeInstance(AnnotationExtractorFieldWriter fieldWriter, T instance) {
						
		final StringBuffer output = new StringBuffer();
		
		output.append("new ");
		output.append(annotationImplementor.getOrCreate(getType()));
		output.append('(');
		output.append(instance.hashCode());
		output.append(", \"");
		output.append(StringEscapeUtils.escapeJava(instance.toString()));
		output.append('\"');
		
		for(final Method m: getCollectedMethods()) {
						
			try {
				
				output.append(", ");
				
				@SuppressWarnings("rawtypes")
				final Class returnType = m.getReturnType();
				
				@SuppressWarnings("unchecked")
				final String field = fieldWriter.createField(returnType, m.invoke(instance));
				
				output.append(field);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}						
		}
		
		output.append(")");
		
		return output.toString();
	}
}
