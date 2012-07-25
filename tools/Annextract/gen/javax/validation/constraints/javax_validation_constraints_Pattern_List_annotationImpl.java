package javax.validation.constraints;

public class javax_validation_constraints_Pattern_List_annotationImpl implements javax.validation.constraints.Pattern.List {
  
  private final int hashCodeValue;
  
  private final java.lang.String toStringValue;
  
  private final javax.validation.constraints.Pattern[] _value;
  
  public javax_validation_constraints_Pattern_List_annotationImpl(int hashCodeValue, java.lang.String toStringValue, javax.validation.constraints.Pattern[] _value) {
    this.hashCodeValue = hashCodeValue;
    this.toStringValue = toStringValue;
    this._value = _value;
  }
  
  public javax.validation.constraints.Pattern[] value() {
    final javax.validation.constraints.Pattern[] local = new javax.validation.constraints.Pattern[this._value.length];
    java.lang.System.arraycopy(this._value, 0, local, 0, this._value.length);
    return local;
  }
  
  public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {
    return javax.validation.constraints.Pattern.List.class;
  }
  
  public java.lang.String toString() {
    return this.toStringValue;
  }
  
  public int hashCode() {
    return this.hashCodeValue;
  }
  
  public boolean equals(java.lang.Object other) {
    
    if(this == other) {
      return true;
    }
    
    if(!(other instanceof javax.validation.constraints.Pattern.List)) {
      return false;
    }
    
    final javax.validation.constraints.Pattern.List casted = (javax.validation.constraints.Pattern.List) other;
    
    return java.util.Arrays.equals(this.value(), casted.value());
  }
}
