package com.logikas.kratools.annextract.client;

public class com_logikas_kratools_annextract_client_Annextract_PersonAnnotationExtractor_extractorImpl implements com.logikas.kratools.annextract.client.Annextract.PersonAnnotationExtractor {
  
  private final java.lang.Class[] _instance_0_ = new java.lang.Class[] {};
  
  private final javax.validation.constraints.Size _instance_1_ = new javax.validation.constraints.javax_validation_constraints_Size_annotationImpl(-2147294872, "@javax.validation.constraints.Size(message=debe tener al menos {0} caracteres, min=12, max=2147483647, payload=[], groups=[])", _instance_0_, 2147483647, "debe tener al menos {0} caracteres", 12, _instance_0_);
  
  public javax.validation.constraints.Size nameSize() {
    return _instance_1_;
  }
  
  private final javax.validation.constraints.Pattern.Flag[] _instance_2_ = new javax.validation.constraints.Pattern.Flag[] {};
  
  private final javax.validation.constraints.Pattern _instance_3_ = new javax.validation.constraints.javax_validation_constraints_Pattern_annotationImpl(-1038760556, "@javax.validation.constraints.Pattern(message={javax.validation.constraints.Pattern.message}, flags=[], payload=[], groups=[], regexp=hello)", _instance_2_, _instance_0_, "{javax.validation.constraints.Pattern.message}", _instance_0_, "hello");
  
  private final javax.validation.constraints.Pattern[] _instance_4_ = new javax.validation.constraints.Pattern[] { _instance_3_ };
  
  private final javax.validation.constraints.Pattern.List _instance_5_ = new javax.validation.constraints.javax_validation_constraints_Pattern_List_annotationImpl(-1038760525, "com.logikas.kratools.annextract.rebind.AnnotationExtractorGeneratorImpl$1@c9690d", _instance_4_);
  
  public javax.validation.constraints.Pattern.List surname() {
    return _instance_5_;
  }
  
  public javax.validation.constraints.Null surnameNull() {
    return null;
  }
  
  private final javax.validation.constraints.Size[] _instance_6_ = new javax.validation.constraints.Size[] { _instance_1_ };
  
  private final javax.validation.constraints.Size.List _instance_7_ = new javax.validation.constraints.javax_validation_constraints_Size_List_annotationImpl(-2147294841, "com.logikas.kratools.annextract.rebind.AnnotationExtractorGeneratorImpl$1@c2a65f", _instance_6_);
  
  public javax.validation.constraints.Size.List surnameSizeList() {
    return _instance_7_;
  }
}
