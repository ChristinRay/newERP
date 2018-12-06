package com.moka.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.dto.SysUserListDto;
import com.moka.model.SysUserRole;

@Mapper
public interface SysUserRoleData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysUserRoleProvider.class, method = "insertSysUserRole")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysUserRole(SysUserRole entity);

	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "selectSysUserRole")
	public List<SysUserRole> selectSysUserRole(SysUserRole entity);

	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserRoleProvider.class, method = "updateSysUserRoleByNullChk")
	public int updateSysUserRoleByNullChk(SysUserRole entity);

	
	/**
	 * 根据登录人userid查询所有角色
	 * @param sysUserListDto
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "findRolesByUserId")
	public Set<Integer> findRolesByUserId(SysUserListDto sysUserListDto);
	
	/**
	 * 更具userid查询授权的url
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "findResUrlByUserId")
	public  Set<String> findResUrlByUserId(Integer userId);
}





