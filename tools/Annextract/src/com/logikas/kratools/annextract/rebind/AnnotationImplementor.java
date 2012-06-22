package com.logikas.kratools.annextract.rebind;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnnotationImplementor {

	private final TreeLogger logger;

	private final GeneratorContext context;

	private static final String HASH_CODE_VALUE = "hashCodeValue";

	private static final String TO_STRING_VALUE = "toStringValue";

	public AnnotationImplementor(TreeLogger logger, GeneratorContext context) {
		this.logger = logger;
		this.context = context;
	}

	private void printFields(SourceWriter writer, List<Method> methods) {

		writer.println();
		writer.println("private final int %s;", HASH_CODE_VALUE);
		writer.println();
		writer.println("private final java.lang.String %s;", TO_STRING_VALUE);

		for (final Method m : methods) {
			writer.println();
			writer.println("private final %s _%s;", m.getReturnType()
					.getCanonicalName(), m.getName());
		}
	}

	private void printConstructorArguments(SourceWriter writer,
			List<Method> methods) {

		writer.print("int %s, java.lang.String %s", HASH_CODE_VALUE,
				TO_STRING_VALUE);

		for (final Method m : methods) {

			writer.print(", ");

			writer.print("%s _%s", m.getReturnType().getCanonicalName(),
					m.getName());
		}
	}

	private void printConstructorAssignments(SourceWriter writer,
			List<Method> methods) {

		writer.println("this.%s = %s;", HASH_CODE_VALUE, HASH_CODE_VALUE);
		writer.println("this.%s = %s;", TO_STRING_VALUE, TO_STRING_VALUE);

		for (final Method m : methods) {
			writer.println("this._%s = _%s;", m.getName(), m.getName());
		}
	}

	private void printMethodImplementations(SourceWriter writer,
			List<Method> methods) {

		for (final Method m : methods) {

			final String returnType = m.getReturnType().getCanonicalName();

			final String methodName = m.getName();

			writer.println();
			writer.println("public %s %s() {", returnType, methodName);

			writer.indent();

			String result = null;

			if (m.getReturnType().isArray()) {

				final String componentType = m.getReturnType()
						.getComponentType().getCanonicalName();
				writer.println("final %s local = new %s[this._%s.length];",
						returnType, componentType, methodName);
				writer.println(
						"java.lang.System.arraycopy(this._%s, 0, local, 0, this._%s.length);",
						methodName, methodName);

				result = "local";
			} else {

				result = "this._" + m.getName();
			}
			writer.println("return %s;", result);
			writer.outdent();
			writer.println("}");
		}
	}

	private void printEqualsImplementation(SourceWriter writer,
			String interfaceName, List<Method> methods) {

		final String other = "other";
		final String casted = "casted";

		writer.println();
		writer.println("public boolean equals(java.lang.Object %s) {", other);

		writer.indent();

		writer.println();

		writer.println("if(this == %s) {", other);
		writer.indentln("return true;");
		writer.println("}");

		writer.println();

		writer.println("if(!(%s instanceof %s)) {", other, interfaceName);
		writer.indentln("return false;");
		writer.println("}");

		writer.println();

		writer.println("final %s %s = (%s) %s;", interfaceName, casted,
				interfaceName, other);

		writer.println();

		boolean hasSeparator = false;

		writer.print("return ");

		for (final Method m : methods) {

			final String methodName = m.getName();

			if (hasSeparator) {
				writer.print(" && ");
			} else {
				hasSeparator = true;
			}

			if (m.getReturnType().isPrimitive()) {

				writer.print("this.%s() == %s.%s()", methodName, casted,
						methodName);
			} else if (m.getReturnType().isArray()) {

				writer.print("java.util.Arrays.equals(this.%s(), %s.%s())",
						methodName, casted, methodName);
			} else {
				/* TODO asegurar que no es necesario el chequeo de nulls */
				// writer.print("this.%s() != null && this.%s().equals(%s.%s())",
				// methodName, methodName, other, methodName);
				writer.print("this.%s().equals(%s.%s())", methodName, casted,
						methodName);
			}
		}

		if (methods.isEmpty()) {
			writer.print("true");
		}

		writer.println(";");

		writer.outdent();

		writer.println("}");
	}

	private void printHashCodeImplementation(SourceWriter writer) {

		writer.println();

		writer.println("public int hashCode() {");

		writer.indentln("return this.%s;", HASH_CODE_VALUE);

		writer.println("}");
	}

	private void printToStringImplementation(SourceWriter writer) {

		writer.println();

		writer.println("public java.lang.String toString() {");

		writer.indentln("return this.%s;", TO_STRING_VALUE);

		writer.println("}");
	}

	private void printAnnotationTypeImplementation(SourceWriter writer,
			String annotationName) {
		writer.println();
		writer.println("public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {");
		writer.indentln("return %s.class;", annotationName);
		writer.println("}");
	}

	public List<Method> collectMethods(
			Class<? extends Annotation> annotationClass) {
		final ArrayList<Method> collected = new ArrayList<Method>();

		for (final Method m : annotationClass.getDeclaredMethods()) {
			// TODO if((m.getModifiers() & Member.PUBLIC) != 0) {
			collected.add(m);
			// }
		}

		Collections.sort(collected, new Comparator<Method>() {

			@Override
			public int compare(Method m1, Method m2) {
				return m1.getName().compareTo(m2.getName());
			}
		});

		return collected;
	}

	public String getOrCreate(final Class<? extends Annotation> type) {

		final String packageName = type.getPackage().getName();

		final String interfaceName = type.getCanonicalName();

		final String implementationName = getImplementationName(type);

		final PrintWriter printWriter = context.tryCreate(logger, packageName,
				implementationName);

		if (printWriter != null) {

			final ClassSourceFileComposerFactory factory = new ClassSourceFileComposerFactory(
					packageName, implementationName);

			factory.addImplementedInterface(interfaceName);

			final SourceWriter sourceWriter = factory.createSourceWriter(
					context, printWriter);

			final List<Method> methods = collectMethods(type);

			implementAnnotation(sourceWriter, type.getCanonicalName(),
					implementationName, methods);

			sourceWriter.commit(logger);

			printWriter.close();
		}

		return packageName + "." + implementationName;
	}

	private String getImplementationName(
			Class<? extends Annotation> annotationClass) {
		final String replaced = annotationClass.getCanonicalName().replace(".",
				"_");
		return String.format("%s_annotationImpl", replaced);
	}

	private void implementAnnotation(SourceWriter writer, String interfaceName,
			String implementationName, List<Method> methods) {

		// private fields
		printFields(writer, methods);

		writer.println();

		// constructor definition
		writer.print("public %s(", implementationName);
		printConstructorArguments(writer, methods);
		writer.println(") {");

		// constructor body
		writer.indent();
		printConstructorAssignments(writer, methods);
		writer.outdent();
		writer.println("}");

		// method implementations
		printMethodImplementations(writer, methods);

		printAnnotationTypeImplementation(writer, interfaceName);

		printToStringImplementation(writer);

		printHashCodeImplementation(writer);

		printEqualsImplementation(writer, interfaceName, methods);

		writer.outdent();
	}
}
