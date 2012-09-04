package com.logikas.kratos.core.document.client;

import com.logikas.kratos.core.document.shared.UploadResult;

import com.google.gwt.core.client.JavaScriptObject;

public class UploadResultJso extends JavaScriptObject implements UploadResult {

  protected UploadResultJso() {
  }

  @Override
  public native final String getDocumentId() /*-{
		return this.documentId || null;
  }-*/;

  @Override
  public native final String getMessage() /*-{
		return this.message || null;
  }-*/;

  private native final String getNativeStatus() /*-{
		return this.status || null;
  }-*/;

  @Override
  public final Status getStatus() {
    final String nativeStatus = getNativeStatus();
    return nativeStatus == null ? null : Status.valueOf(nativeStatus);
  }
}
