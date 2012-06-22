package com.logikas.kratools.annextract.shared;

import java.lang.annotation.Annotation;

public interface Unwrapper<T extends Annotation> {
  
  T filter(T[] annotations);
}
