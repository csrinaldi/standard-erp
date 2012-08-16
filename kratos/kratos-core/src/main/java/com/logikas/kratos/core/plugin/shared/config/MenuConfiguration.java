package com.logikas.kratos.core.plugin.shared.config;

public interface MenuConfiguration {
  
  void configure(MenuNodeBuilder builder);
  
  
  /**
   * Persiste el estado del menu
   * //TODO lo ideal seria usar el LocalStore del cliente para menjar estas cosas
   */
  void save();
  
  /**
   * Levanta el estado del menu
   * //Guardar en el local store del cliente la configuracion del menu
   */
  void load();
}
