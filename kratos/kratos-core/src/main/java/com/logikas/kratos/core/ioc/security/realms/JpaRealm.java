/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc.security.realms;

import com.logikas.kratos.core.ioc.security.service.SecurityService;
import javax.inject.Inject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Realms que optiene los permisos el Usuario y haciendo uso de JPA.
 * //TODO podemos cambiar el nombre a CoreRealm y mandar todo lo de JPA
 * a SecurityService
 * @author csrinaldi
 */
public class JpaRealm extends AuthorizingRealm{

    SecurityService service;
    
    @Inject
    public JpaRealm(SecurityService service) {
        this.service = service;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        
                
        
        
        return null;
    }
    
}
