package com.moka.shiro_redis_config;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.SysUserData;
import com.moka.model.SysUser;

/**
* @author    created by lbq
* @date	     2018年9月20日 上午11:25:08
**/
@Service
public class UserService {
	
	@Autowired
	private SysUserData sysUserData;

	/**
	 * 得到这个用户
	 * @param user
	 * @return
	 */
	public SysUser getUser(SysUser user) {
		List<SysUser> sysUsers= sysUserData.selectSysUser(user);
		
		
		return sysUsers.get(0);
	}
	/**
	 * 根据用户id找到用户对应的权限
	 * @param id
	 * @return
	 */
	public Set<String> findPermissionsByUserId(Integer id) {
		return null;
	}

}
