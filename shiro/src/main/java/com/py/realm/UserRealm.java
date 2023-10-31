package com.py.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();

        SimpleAuthenticationInfo authenticationInfo = null;
        // authenticationInfo = new SimpleAuthenticationInfo(
        //         "4169", //用户名
        //         "b01ee9eebc7ef323715835275278e214", //密码
        //         new SimpleByteSource(("1665285232324" + "411d858bc55d54b309f87bfd3d2c7ae1").getBytes()),//salt=username+salt
        //         getName()  //realm name
        // );
        authenticationInfo = new SimpleAuthenticationInfo(
                "1041", //用户名
                "f5af9b3747a98e00a2118097f82339f6", //密码
                new SimpleByteSource(("1451324475474" + "d2feed3797f65c5839799d144257a167").getBytes()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }


    
}

