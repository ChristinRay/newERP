package com.moka.shiro_redis_config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
* @author    created by lbq
* @date	     2018年11月20日 上午10:24:44
**/
public class CustomRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从主体传过来的认证
		String userName=(String)token.getPrincipal();
		//2.通过用户名到数据库中获取凭证
		String password=getPasswordByUserName(userName);
		
		return null;
	}

	private String getPasswordByUserName(String userName) {
		//
		return null;
	}

}
