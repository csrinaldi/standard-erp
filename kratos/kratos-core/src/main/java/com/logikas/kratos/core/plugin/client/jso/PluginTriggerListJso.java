package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginTrigger;
import com.logikas.kratos.core.plugin.shared.PluginTriggerList;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.Iterator;

class PluginTriggerListJso extends JavaScriptObject implements PluginTriggerList {
  
  protected PluginTriggerListJso() {}
  
  static PluginTriggerListJso create() {
    return JavaScriptObject.createArray().cast();    
  }

  @Override
  public Iterator<PluginTrigger> iterator() {

    final JsArray<PluginTriggerJso> array = this.cast(); 
    
    final int length = array.length();
    
    return new Iterator<PluginTrigger>() {
            
      int index = 0;
      
      @Override
      public boolean hasNext() {
        return index < length;
      }

      @Override
      public PluginTrigger next() {
        PluginTriggerJso next = array.get(index);
        index++;
        return next;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
