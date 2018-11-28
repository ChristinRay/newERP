package com.moka.dao;

import java.util.Objects;

import org.apache.ibatis.jdbc.SQL;

import com.moka.dto.SysUserListDto;
import com.moka.model.SysUserRole;

/**
 * 用户角色中间表
 * provider
 */
public class SysUserRoleProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysUserRole(SysUserRole entity) {
		SQL sql = new SQL().INSERT_INTO("sys_user_role");
		sql.VALUES("user_id,role_id", "#{userId},#{roleId}");
		return sql.toString();
	}
	

	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysUserRole(SysUserRole entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_user_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}

		return sql.toString();
	}


	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateSysUserRoleByNullChk(SysUserRole entity) {
		SQL sql = new SQL().UPDATE("sys_user_role");
					if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.SET("role_id = #{roleId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}

	/**
	 * 根据userid查询 userid的角色
	 * @param entity
	 * @return
	 */
	public String findRolesByUserId(SysUserListDto sysUserListDto) {
		SQL sql = new SQL().SELECT("role_id as roleId").FROM("sys_user_role");
		sql.WHERE(" user_id=#{id}");
		return sql.toString();
	} 
}
