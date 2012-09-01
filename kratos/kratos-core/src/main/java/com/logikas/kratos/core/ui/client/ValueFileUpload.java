package com.logikas.kratos.core.ui.client;

import com.logikas.kratos.core.ui.client.adapters.HasUrlEditor;

import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FileUpload;

import elemental.client.Browser;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.FileList;
import elemental.html.FileReader;
import elemental.html.InputElement;

public class ValueFileUpload extends FileUpload implements IsEditor<LeafValueEditor<String>>,
    HasUrl {

  private String url = null;
  
  private native static final InputElement getElemental(Element element) /*-{
    return element;
  }-*/;
  
  
  private InputElement getElemental(){
    return getElemental(getElement());
  }

  public ValueFileUpload() {
   addChangeHandler(new ChangeHandler() {

      @Override
      public void onChange(ChangeEvent event) {

        final FileList files = getElemental().getFiles();

        if (files.getLength() > 0) {
          final FileReader reader = Browser.getWindow().newFileReader();
          reader.readAsDataURL(files.item(0));
          reader.setOnloadend(new EventListener() {

            @Override
            public void handleEvent(Event evt) {
              url = (String) reader.getResult();
            }
          });
        }

      }
    });
  }

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public void setUrl(String url) {
    // Nada que hacer
  }

  @Override
  public LeafValueEditor<String> asEditor() {
    return HasUrlEditor.of(this);
  }
}
