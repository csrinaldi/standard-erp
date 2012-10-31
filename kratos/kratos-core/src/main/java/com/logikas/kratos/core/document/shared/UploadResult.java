package com.logikas.kratos.core.document.shared;

public interface UploadResult {
  
  public static enum Status {
    OK, VALIDATION_ERROR, INTERNAL_ERROR;
  }
  
  String getDocumentId();
  void setDocumentId(String documentId);
  
  Status getStatus();
  void setStatus(Status status);
  
  String getMessage();
  void setMessage(String message);
}
