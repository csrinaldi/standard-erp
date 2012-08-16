package com.logikas.kratos.core.plugin.shared.model;

public interface MenuNode {
  
  String getToken();
  
  String getIcon();
  
  String getTitle();
  
  String getTooltip();
  
  int getPriority();
  
  public static interface Visitor {
    
    void onChild(MenuNode node);
  }
  
  void visitChildren(Visitor visitor);
}
