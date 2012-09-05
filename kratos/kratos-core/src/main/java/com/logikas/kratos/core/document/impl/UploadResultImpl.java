package com.logikas.kratos.core.document.impl;

import com.logikas.kratos.core.document.shared.UploadResult;

import org.json.JSONObject;

public class UploadResultImpl implements UploadResult {
  
  private final String documentId;
  private final Status status;
  private final String message;
  
  public static UploadResult createValid(String documentId) {
    return new UploadResultImpl(documentId, Status.OK, null);
  }
  
  public static UploadResult createValidationError(String message ) {
    return new UploadResultImpl(null, Status.VALIDATION_ERROR, message);
  }
  
  public static UploadResult createInternalError(String message ) {
    return new UploadResultImpl(null, Status.INTERNAL_ERROR, message);
  }
    
  public static String serialize(UploadResult result) {
    final String documentId = JSONObject.quote(result.getDocumentId());
    final String status = JSONObject.quote(result.getStatus().name());
    final String message = JSONObject.quote(result.getMessage());
    return String.format("{\"documentId\": %s, \"status\": %s, \"message\": %s}", documentId, status, message);
   }
  
  protected UploadResultImpl(String documentId, Status status, String message) {
    this.documentId = documentId;
    this.status = status;
    this.message = message;
  }
  
  @Override
  public String getDocumentId() {
    return documentId;
  }

  @Override
  public Status getStatus() {
    return status;
  }

  @Override
  public String getMessage() {
    return message;
  }  
}
