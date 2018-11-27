package com.moka.shiro_redis_config;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.moka.model.SysUser;
import com.moka.service.UserService;

/**
 * 自定义Realm
 * @author created by lbq
 * @date 2018年9月19日 下午7:45:29
 **/
public class MyShiroRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	// 如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * 授权查看登录人权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
		Object principal = principals.getPrimaryPrincipal();//身份验证
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (principal instanceof SysUser) {
			SysUser userLogin = (SysUser) principal;
			Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId());//根据用户id得到用户的所有角色
			authorizationInfo.addRoles(roles);

			Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());//根据登录人用户id得到用户所有权限
			authorizationInfo.addStringPermissions(permissions);
		}
		logger.info("---- 获取到以下权限 ----");
		logger.info(authorizationInfo.getStringPermissions().toString());
		logger.info("---------------- Shiro 权限获取成功 ----------------------");
		return authorizationInfo;
	}

	/**
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 *
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		String password = String.valueOf(token.getPassword());
		SysUser user = new SysUser();
		user.setUsername(name);	
		user.setPassword(password);
		// 从数据库获取对应用户名密码的用户
		SysUser userList = userService.getUser(user);
		
		if (userList != null) {
			// 用户为禁用状态
			if (userList.getUserEnable() != 1) {
				throw new DisabledAccountException();
			}
			logger.info("---------------- Shiro 凭证认证成功 ----------------------");
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					userList, // 用户
					userList.getPassword(), // 密码
					getName() // realm name
			);
			return authenticationInfo;
		}
		throw new UnknownAccountException();
	}

}
