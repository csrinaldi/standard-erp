package com.logikas.kratos.core.document.shared;


import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface DocumentFactory extends AutoBeanFactory {
  
  AutoBean<UploadResult> uploadResult();
}
