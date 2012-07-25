package javax.validation.constraints;

public class javax_validation_constraints_Pattern_annotationImpl implements javax.validation.constraints.Pattern {
  
  private final int hashCodeValue;
  
  private final java.lang.String toStringValue;
  
  private final javax.validation.constraints.Pattern.Flag[] _flags;
  
  private final java.lang.Class[] _groups;
  
  private final java.lang.String _message;
  
  private final java.lang.Class[] _payload;
  
  private final java.lang.String _regexp;
  
  public javax_validation_constraints_Pattern_annotationImpl(int hashCodeValue, java.lang.String toStringValue, javax.validation.constraints.Pattern.Flag[] _flags, java.lang.Class[] _groups, java.lang.String _message, java.lang.Class[] _payload, java.lang.String _regexp) {
    this.hashCodeValue = hashCodeValue;
    this.toStringValue = toStringValue;
    this._flags = _flags;
    this._groups = _groups;
    this._message = _message;
    this._payload = _payload;
    this._regexp = _regexp;
  }
  
  public javax.validation.constraints.Pattern.Flag[] flags() {
    final javax.validation.constraints.Pattern.Flag[] local = new javax.validation.constraints.Pattern.Flag[this._flags.length];
    java.lang.System.arraycopy(this._flags, 0, local, 0, this._flags.length);
    return local;
  }
  
  public java.lang.Class[] groups() {
    final java.lang.Class[] local = new java.lang.Class[this._groups.length];
    java.lang.System.arraycopy(this._groups, 0, local, 0, this._groups.length);
    return local;
  }
  
  public java.lang.String message() {
    return this._message;
  }
  
  public java.lang.Class[] payload() {
    final java.lang.Class[] local = new java.lang.Class[this._payload.length];
    java.lang.System.arraycopy(this._payload, 0, local, 0, this._payload.length);
    return local;
  }
  
  public java.lang.String regexp() {
    return this._regexp;
  }
  
  public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {
    return javax.validation.constraints.Pattern.class;
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
    
    if(!(other instanceof javax.validation.constraints.Pattern)) {
      return false;
    }
    
    final javax.validation.constraints.Pattern casted = (javax.validation.constraints.Pattern) other;
    
    return java.util.Arrays.equals(this.flags(), casted.flags()) && java.util.Arrays.equals(this.groups(), casted.groups()) && this.message().equals(casted.message()) && java.util.Arrays.equals(this.payload(), casted.payload()) && this.regexp().equals(casted.regexp());
  }
}
