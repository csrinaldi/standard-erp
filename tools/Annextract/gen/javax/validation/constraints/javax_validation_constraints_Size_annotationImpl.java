package javax.validation.constraints;

public class javax_validation_constraints_Size_annotationImpl implements javax.validation.constraints.Size {
  
  private final int hashCodeValue;
  
  private final java.lang.String toStringValue;
  
  private final java.lang.Class[] _groups;
  
  private final int _max;
  
  private final java.lang.String _message;
  
  private final int _min;
  
  private final java.lang.Class[] _payload;
  
  public javax_validation_constraints_Size_annotationImpl(int hashCodeValue, java.lang.String toStringValue, java.lang.Class[] _groups, int _max, java.lang.String _message, int _min, java.lang.Class[] _payload) {
    this.hashCodeValue = hashCodeValue;
    this.toStringValue = toStringValue;
    this._groups = _groups;
    this._max = _max;-2147294872
    this._message = _message;
    this._min = _min;
    this._payload = _payload;
  }
  
  public java.lang.Class[] groups() {
    final java.lang.Class[] local = new java.lang.Class[this._groups.length];
    java.lang.System.arraycopy(this._groups, 0, local, 0, this._groups.length);
    return local;
  }
  
  public int max() {
    return this._max;
  }
  
  public java.lang.String message() {
    return this._message;
  }
  
  public int min() {
    return this._min;
  }
  
  public java.lang.Class[] payload() {
    final java.lang.Class[] local = new java.lang.Class[this._payload.length];
    java.lang.System.arraycopy(this._payload, 0, local, 0, this._payload.length);
    return local;
  }
  
  public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {
    return javax.validation.constraints.Size.class;
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
    
    if(!(other instanceof javax.validation.constraints.Size)) {
      return false;
    }
    
    final javax.validation.constraints.Size casted = (javax.validation.constraints.Size) other;
    
    return java.util.Arrays.equals(this.groups(), casted.groups()) && this.max() == casted.max() && this.message().equals(casted.message()) && this.min() == casted.min() && java.util.Arrays.equals(this.payload(), casted.payload());
  }
}
