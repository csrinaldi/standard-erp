package com.logikas.kratos.core.plugin.shared;

/**
 * 
 * @author atesti
 *
 * Estos plugins pueden ser definidos mediante JSON o mediante #PluginDefinitionBuilder
 * 
 * mediante JSON:
 * 
 *  { 
 *    name: 'system',
 *    title: 'System management',
 *    placeTriggers: [ 
 *      {
 *        name: 'CreateUser',
 *        title: 'Create user',
 *        image: 'img/createUser.jpg',
 *      }
 *    ]
 *    actionTriggers: [
 *    
 *    ]
 *    
 *  mediante Builder:
 *  
 *  builder.define("system", "System management").place("CreateUser", "Create user", "img/createUser.jpg").build()
 *
 */
public interface PluginDefinition {
  
  String getName();
  
  String getTitle();
  
  PluginTriggerList getPlaceTriggers();
  
  PluginTriggerList getActionTriggers();
}
