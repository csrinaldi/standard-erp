package com.logikas.kratos.core.plugin.shared.config;

public interface MenuNodeBuilder {

  MenuNodeBuilder token(String token);

  MenuNodeBuilder title(String title);

  MenuNodeBuilder tooltip(String tooltip);

  MenuNodeBuilder icon(String icon);

  MenuNodeBuilder priority(int priority);

  MenuNodeBuilder child(String name);
}
