package com.logikas.kratos.core.plugin.shared.config.reader;

import com.logikas.kratos.core.plugin.shared.config.MenuConfiguration;
import com.logikas.kratos.core.plugin.shared.config.MenuNodeBuilder;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;

public class MenuNodeReader implements MenuConfiguration {

  private final MenuNode node;

  public MenuNodeReader(MenuNode node) {
    this.node = node;
  }

  @Override
  public void configure(final MenuNodeBuilder builder) {

    builder.token(node.getToken());
    builder.title(node.getTitle());
    builder.tooltip(node.getTooltip());
    builder.priority(node.getPriority());
    builder.icon(node.getIcon());

    node.visitChildren(new MenuNode.Visitor() {

      @Override
      public void visit(String name, MenuNode child) {
        //configure(builder.child(name));
      }
    });
  }
}
