package com.logikas.kratos.core.ui.client;

import com.logikas.kratos.common.base.Converter;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.Image;

public class Values {

  public static <T> void fire(HasValueChangeHandlers<T> source, final TakesValue<T>... target) {
    source.addValueChangeHandler(new ValueChangeHandler<T>() {
      @Override
      public void onValueChange(ValueChangeEvent<T> event) {
        for (final TakesValue<T> t : target) {
          t.setValue(event.getValue());
        }
      }
    });
  }

  public static TakesValue<String> url(final HasUrl wrap) {
    return new TakesValue<String>() {

      @Override
      public void setValue(String value) {
        wrap.setUrl(value);
      }

      @Override
      public String getValue() {
        return wrap.getUrl();
      }
    };
  }

  public static TakesValue<Boolean> not(final TakesValue<Boolean> wrap) {
        
    return new TakesValue<Boolean>() {
      @Override
      public Boolean getValue() {
        return wrap.getValue() == null? true: !wrap.getValue();
      }
      
      @Override
      public void setValue(Boolean value) {
        wrap.setValue(value == null? true: !value);        
      }
    };
  }
  
  public static TakesValue<Boolean> enabled(final HasEnabled wrap) {
    return new TakesValue<Boolean>() {
      
      @Override
      public Boolean getValue() {
        return wrap.isEnabled();
      }
      
      @Override
      public void setValue(Boolean value) {
        wrap.setEnabled(value == null? false: value);
      }
    };
  }

  public static TakesValue<Boolean> visibility(final HasVisibility wrap) {

    return new TakesValue<Boolean>() {

      @Override
      public void setValue(Boolean value) {
        wrap.setVisible(value != null ? value : false);
      }

      @Override
      public Boolean getValue() {
        return wrap.isVisible();
      }
    };
  }

  public static TakesValue<String> text(final HasText wrap) {
    return new TakesValue<String>() {

      @Override
      public void setValue(String value) {
        wrap.setText(value);
      }

      @Override
      public String getValue() {
        return wrap.getText();
      }
    };
  }

  public static <F, T> TakesValue<T> converted(final TakesValue<F> wrap,
      final Converter<F, T> converter) {

    return new TakesValue<T>() {

      @Override
      public T getValue() {
        return converter.apply(wrap.getValue());
      }

      public void setValue(T value) {
        wrap.setValue(converter.inverse().apply(value));
      }
    };
  }

  public static HasUrl hasUrl(final Anchor anchor) {
    return new HasUrl() {

      @Override
      public void setUrl(String url) {
        anchor.setHref(url);
      }

      @Override
      public String getUrl() {
        return anchor.getHref();
      }
    };
  }

  public static HasUrl hasUrl(final Image image) {
    return new HasUrl() {

      @Override
      public void setUrl(String url) {
        image.setUrl(url);
      }

      @Override
      public String getUrl() {
        return image.getUrl();
      }
    };
  }
  
  public static HasUrl hasUrl(final Frame frame) {
    return new HasUrl() {

      @Override
      public void setUrl(String url) {
        frame.setUrl(url);
      }

      @Override
      public String getUrl() {
        return frame.getUrl();
      }
    };
  }

}
