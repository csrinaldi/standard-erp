/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var ModuleRegistry = (function(){
    
    var modules = {};
    var handlers = [];
    
    return {
        subscribe: function(moduleInfo) {
            if(modules[moduleInfo.name]) {
                return false;
            }
            modules[moduleInfo.name] = moduleInfo;
            for( var i=0;  i < modules.length; i++){
                handlers[i](moduleInfo);
            }
            return true;
        },
        
        addHandler: function(handler) {
            var n = handlers.length;
            handlers[n] = handler;
            return n;
        },
        
        removeHandler: function(n){
            handlers[n] = null;            
        },
        
        getModules : function(){
            return modules;
        }
    };
})();

