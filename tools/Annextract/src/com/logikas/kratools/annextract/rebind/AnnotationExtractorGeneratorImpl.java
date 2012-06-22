package com.logikas.kratools.annextract.rebind;

import com.logikas.kratools.annextract.shared.AllowedWrappers;
import com.logikas.kratools.annextract.shared.AnnotationExtractor;
import com.logikas.kratools.annextract.shared.DefaultsToNull;
import com.logikas.kratools.annextract.shared.ExtractorFor;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.HasAnnotations;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AnnotationExtractorGeneratorImpl {

  private final TreeLogger logger;

  private final GeneratorContext context;

  public AnnotationExtractorGeneratorImpl(TreeLogger logger, GeneratorContext context) {
    this.logger = logger;
    this.context = context;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public String generate(String typeName) throws UnableToCompleteException {

    final JClassType inspectorType = getInspectorType(typeName);

    final Class<?> inspectedClass = getInspectedClass(inspectorType);

    final AnnotationImplementor implementor = new AnnotationImplementor(logger, context);

    final String packageName = inspectorType.getPackage().getName();

    final String implementationName = getImplementationName(inspectorType);

    final String qualifiedImplementationName = packageName + "." + implementationName;

    final PrintWriter printWriter = context.tryCreate(logger, packageName, implementationName);

    if (printWriter == null) {
      return qualifiedImplementationName;
    }

    final ClassSourceFileComposerFactory factory =
        new ClassSourceFileComposerFactory(packageName, implementationName);

    factory.addImplementedInterface(inspectorType.getQualifiedSourceName());

    final SourceWriter sourceWriter = factory.createSourceWriter(context, printWriter);

    final boolean typeDefaultsToNull = defaultsToNull(inspectorType);

    final AnnotationExtractorFieldWriter fieldWriter =
        new AnnotationExtractorFieldWriter(sourceWriter, implementor);

    fieldWriter.initialize();

    for (final JMethod m : inspectorType.getMethods()) {

      final Annotation annotation = extractAnnotation(m, inspectedClass);

      final String methodName = m.getName();
      final String returnType = m.getReturnType().getQualifiedSourceName();

      String result = null;

      if (annotation == null) {

        if (!typeDefaultsToNull && !defaultsToNull(m)) {

          logger.log(Type.ERROR, String.format(
              "Property referred by method '%s' in class %s is not annotated with %s", methodName,
              inspectorType.getQualifiedSourceName(), returnType));
          throw new UnableToCompleteException();
        }

        result = "null";
      } else {

        result = fieldWriter.createField((Class) annotation.annotationType(), annotation);
      }
      sourceWriter.println();
      sourceWriter.println("public %s %s() {", returnType, methodName);
      sourceWriter.indentln("return %s;", result);
      sourceWriter.println("}");
    }

    sourceWriter.commit(logger);

    fieldWriter.clear();

    return qualifiedImplementationName;
  }

  private boolean defaultsToNull(HasAnnotations type) {
    return type.getAnnotation(DefaultsToNull.class) != null;
  }

  private final HashMap<JMethod, Set<Class<? extends Annotation>>> cachedWrappers =
      new HashMap<JMethod, Set<Class<? extends Annotation>>>();

  @SuppressWarnings({"unchecked", "rawtypes"})
  private boolean allowsWrapping(JMethod method, Class<? extends Annotation> annotationType) {

    Set<Class<? extends Annotation>> cached = cachedWrappers.get(method);

    if (cached == null) {

      final AllowedWrappers methodWrappers = method.getAnnotation(AllowedWrappers.class);
      Class[] value = {};

      if (methodWrappers != null) {
        value = methodWrappers.value();
      } else {

        final AllowedWrappers classWrappers =
            method.getEnclosingType().getAnnotation(AllowedWrappers.class);

        if (classWrappers != null) {
          value = classWrappers.value();
        }
      }

      cached = new HashSet<Class<? extends Annotation>>();
      Collections.addAll((HashSet) cached, value);
      cachedWrappers.put(method, cached);
    }

    return !cached.isEmpty() && cached.contains(AllowedWrappers.Any.class)
        || cached.contains(annotationType);
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private Annotation extractAnnotation(JMethod method, Class<?> inspectedClass)
      throws UnableToCompleteException {

    final String methodName = method.getName();
    final String inspectorClassName = method.getEnclosingType().getQualifiedSourceName();
    final String annotationClassName = method.getReturnType().getQualifiedSourceName();
    final String annotationBinaryName = method.getReturnType().getQualifiedBinaryName();
    final String inspectedClassName = inspectedClass.getCanonicalName();

    if (method.getParameters().length > 0) {
      logger.log(Type.ERROR, String.format(
          "Parameter list in method '%s' from interface %s is not empty", methodName,
          inspectorClassName));
      throw new UnableToCompleteException();
    }

    final JType returnType = method.getReturnType();

    if (returnType.isAnnotation() == null) {
      logger.log(Type.ERROR, String.format(
          "Return type %s in method '%s' from interface %s is not an annotation type",
          annotationClassName, methodName, inspectorClassName));
      throw new UnableToCompleteException();
    }

    final String propertyName = getPropertyName(method);

    final String getterName = getGetterName(propertyName);

    try {
      final Method getter = inspectedClass.getMethod(getterName);
      final Class<? extends Annotation> returnAnnotationType =
          (Class) Class.forName(annotationBinaryName);
      final Annotation returnAnnotation = getter.getAnnotation(returnAnnotationType);

      if (returnAnnotation == null && allowsWrapping(method, returnAnnotationType)) {

        final Class<? extends Annotation> wrappedAnnotationType =
            getWrappedAnnotationType(returnAnnotationType);

        if (wrappedAnnotationType == null) {
          return null;
        }

        final Annotation wrappedAnnotation = getter.getAnnotation(wrappedAnnotationType);

        Object[] array = null;

        if (wrappedAnnotation == null) {
          array = (Object[]) Array.newInstance(wrappedAnnotationType, 0);
        } else {

          array = (Object[]) Array.newInstance(wrappedAnnotationType, 1);

          array[0] = wrappedAnnotation;
        }

        return instantiateWrapper(returnAnnotationType, wrappedAnnotationType, array);
      }

      return returnAnnotation;

    } catch (SecurityException e) {
      logger.log(Type.ERROR, String.format("Security exception inspecting method 's%' in class %s",
          methodName, inspectedClassName), e);
      throw new UnableToCompleteException();
    } catch (NoSuchMethodException e) {
      logger.log(Type.ERROR, String.format(
          "Getter not found for property '%s' in class %s refered by inspector class %s",
          propertyName, inspectedClassName, inspectorClassName));
      throw new UnableToCompleteException();
    } catch (ClassNotFoundException e) {

      logger.log(Type.ERROR, String.format(
          "Annotation class %s not found for property '%s' in class %s", annotationClassName,
          propertyName, inspectedClassName), e);
      throw new UnableToCompleteException();
    }
  }

  // TODO Experimental. Buscar una alternativa para instanciar annotations
  private Annotation instantiateWrapper(final Class<? extends Annotation> wrapperType,
      final Class<?> wrappedType, final Object[] array) throws UnableToCompleteException {
    // TODO resolver equals(), toString() y hashCode()
    return (Annotation) Proxy.newProxyInstance(wrapperType.getClassLoader(),
        new Class[] {wrapperType}, new InvocationHandler() {

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) {
            if (method.getName().equals("value")) {
              return array;
            }

            if (method.getName().equals("equals")) {

              Object other = args[0];

              if (other == this) {
                return true;
              }

              if (!wrapperType.isInstance(other)) {
                return false;
              }

              try {
                final Object[] otherValue =
                    (Object[]) other.getClass().getMethod("value").invoke(other);
                return Arrays.equals(array, otherValue);
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
            }

            if (method.getName().equals("hashCode")) {
              return Arrays.hashCode(array);
            }

            if (method.getName().equals("toString")) {
              return toString();
            }

            if (method.getName().equals("getClass")) {
              return wrapperType;
            }

            if (method.getName().equals("annotationType")) {
              return wrapperType;
            }

            return method.getDefaultValue();
          }
        });
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private Class<? extends Annotation> getWrappedAnnotationType(
      Class<? extends Annotation> returnAnnotationType) throws UnableToCompleteException {

    try {

      final Method valueMethod = returnAnnotationType.getMethod("value");

      final Class<?> arrayType = valueMethod.getReturnType();

      if (!arrayType.isArray()) {
        return null;
      }

      final Class<?> wrappedAnnotationType = arrayType.getComponentType();

      if (!wrappedAnnotationType.isAnnotation()) {
        return null;
      }

      for (final Method m : returnAnnotationType.getDeclaredMethods()) {
        if (!m.getName().equals("value") && m.getDefaultValue() == null) {
          // No defaults for non value() methods. Not a wrapper
          return null;
        }
      }

      return (Class) wrappedAnnotationType;

    } catch (SecurityException e) {
      logger.log(Type.ERROR, "Security exception accessing to method value() from "
          + returnAnnotationType.getCanonicalName());
      throw new UnableToCompleteException();
    } catch (NoSuchMethodException e) {
      return null;
    }
  }

  // TODO cambiar por Guava
  private String getGetterName(String propertyName) {
    final char c = propertyName.charAt(0);
    final char first =
        Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    return "get" + first + propertyName.substring(1);
  }

  private String getPropertyName(JMethod method) throws UnableToCompleteException {

    final String methodName = method.getName();
    final String inspectorClassName = method.getEnclosingType().getQualifiedSourceName();
    final String annotationClassName = method.getReturnType().getQualifiedSourceName();

    final AnnotationExtractor.Property property =
        method.getAnnotation(AnnotationExtractor.Property.class);

    if (property != null) {
      return property.value();
    }

    final String methodSuffix = method.getReturnType().getSimpleSourceName();

    if (!methodName.endsWith(methodSuffix)) {

      logger.log(Type.ERROR, String.format(
          "Method name suffix in method '%s' from interface %s do not match with return type %s",
          methodName, inspectorClassName, annotationClassName));
      throw new UnableToCompleteException();
    }
    return methodName.substring(0, methodName.length() - methodSuffix.length());
  }

  private String getImplementationName(JClassType inspectorType) {
    final String replaced = inspectorType.getQualifiedSourceName().replace(".", "_");
    return String.format("%s_extractorImpl", replaced);
  }

  private JClassType getInspectorType(String typeName) throws UnableToCompleteException {

    final JClassType inspectorType = context.getTypeOracle().findType(typeName);

    if (inspectorType == null) {
      logger.log(Type.ERROR, String.format("Inspector type %s not found", typeName));
      throw new UnableToCompleteException();

    }

    if (inspectorType.isInterface() == null) {
      logger.log(Type.ERROR, String.format("%s must be an interface", inspectorType
          .getQualifiedSourceName()));
      throw new UnableToCompleteException();
    }

    return inspectorType;
  }

  private Class<?> getInspectedClass(JClassType inspectorType) throws UnableToCompleteException {

    final ExtractorFor inspectorFor = inspectorType.getAnnotation(ExtractorFor.class);

    if (inspectorFor == null) {
      logger.log(Type.ERROR, String.format("Class %s must be annotated with %s", inspectorType
          .getQualifiedSourceName(), ExtractorFor.class.getCanonicalName()));
      throw new UnableToCompleteException();
    }

    return inspectorFor.value();
  }
}
