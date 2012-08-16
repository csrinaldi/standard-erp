package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.config.MenuNodeBuilder;

import com.google.gwt.core.client.JavaScriptObject;

class JsoMenuNodeBuilder extends JavaScriptObject implements MenuNodeBuilder {

  protected JsoMenuNodeBuilder() {
  }

  private static final JsoMenuNodeBuilder create() {
    return JsoMenuNode.create().cast();
  }

  protected final JsoMenuNode getMenuNode() {
    return cast();
  }

  @Override
  public final MenuNodeBuilder icon(String icon) {
    getMenuNode().setIcon(icon);
    return this;
  }

  @Override
  public final MenuNodeBuilder title(String title) {
    getMenuNode().setTitle(title);
    return this;
  }

  @Override
  public MenuNodeBuilder token(String token) {
    getMenuNode().setToken(token);
    return this;
  }

  @Override
  public MenuNodeBuilder tooltip(String tooltip) {
    getMenuNode().setTooltip(tooltip);
    return this;
  }

  @Override
  public MenuNodeBuilder priority(int priority) {
    getMenuNode().setPriority(priority);
    return this;
  }

  @Override
  public final MenuNodeBuilder child(String name) {
    final JsoMenuNodeBuilder child = create();
    getMenuNode().addChild(name, child.getMenuNode());
    return child;
  }
}
