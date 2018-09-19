package com.moka.test;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
/**
* @author    created by lbq
* @date	     2018年9月19日 下午4:26:27
**/
public class Authentication {
	
	@Test
	public void testAuthentication(){
		JdbcRealm jdbcRealm =new JdbcRealm();
		
		
		//1.构建SecurityManager环境
		DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
		
		//2主体提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject=SecurityUtils.getSubject();
		
		UsernamePasswordToken token =new UsernamePasswordToken("lbq", "123456");
		subject.login(token);
		
		System.out.println("是否认证："+subject.isAuthenticated()); //是否认证
		subject.logout();
		
	}
}