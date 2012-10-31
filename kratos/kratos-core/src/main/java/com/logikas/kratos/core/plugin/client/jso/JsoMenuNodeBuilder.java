package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.config.MenuNodeBuilder;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;

public class JsoMenuNodeBuilder implements MenuNodeBuilder {

  private final JsoMenuNode menuNode;

  JsoMenuNodeBuilder(JsoMenuNode menuNode) {
    this.menuNode = menuNode;
  }

  protected final JsoMenuNode getMenuNode() {
    return menuNode;
  }

  public MenuNode menuNode() {
    return menuNode;
  }

  public JsoMenuNodeBuilder() {
    this(JsoMenuNode.create());
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
  public final MenuNodeBuilder child(String name, MenuNode node) {
    getMenuNode().addChild(name, (JsoMenuNode)node);
    return this;
  }
}
