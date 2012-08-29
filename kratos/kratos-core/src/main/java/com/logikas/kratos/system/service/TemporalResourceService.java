package com.logikas.kratos.system.service;

import java.io.InputStream;
import java.util.Date;

public interface TemporalResourceService {
  
  Long create(String filename, String contentType, InputStream content);
  
  InputStream getStream(Long id);
  
  Date getCreated(Long id);
  
  String getSessionId(Long id);
}
