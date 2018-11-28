package com.moka.dao;

import java.util.Objects;

import org.apache.ibatis.jdbc.SQL;

import com.moka.model.SysRoleResources;

/**
 * 
 * provider
 */
public class SysRoleResourcesProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysRoleResources(SysRoleResources entity) {
		SQL sql = new SQL().INSERT_INTO("sys_role_resources");
		sql.VALUES("role_id,resources_id", "#{roleId},#{resourcesId}");
		return sql.toString();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysRoleResources(SysRoleResources entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role_resources");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}
			if(!Objects.isNull(entity.getResourcesId())) {sql.WHERE("resources_id = #{resourcesId}");}

		return sql.toString();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectAll() {
		SQL sql = new SQL().SELECT("id,role_id as roleId,resources_id as resourcesId").FROM("sys_role_resources");

		return sql.toString();
	}
	/**
	 * 查询角色
	 * @return
	 */
	public String selectRoles(){
		SQL sql = new SQL().SELECT("DISTINCT role_id as roleId").FROM("sys_role_resources");
		return sql.toString();
	}
}
