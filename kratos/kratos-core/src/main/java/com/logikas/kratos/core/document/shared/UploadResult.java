package com.logikas.kratos.core.document.shared;

public interface UploadResult {
  
  public static enum Status {
    OK, VALIDATION_ERROR, INTERNAL_ERROR;
  }
  
  String getDocumentId();
  
  Status getStatus();
  
  String getMessage();
}
