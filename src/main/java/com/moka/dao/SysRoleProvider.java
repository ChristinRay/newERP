package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.SysRole;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * 角色表
 * provider
 */
public class SysRoleProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysRole(SysRole entity) {
		SQL sql = new SQL().INSERT_INTO("sys_role");
		sql.VALUES("role_desc", "#{roleDesc}");
		return sql.toString();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysRole(SysRole entity) {
		SQL sql = new SQL().SELECT("id,role_desc as roleDesc").FROM("sys_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getRoleDesc())) {sql.WHERE("role_desc = #{roleDesc}");}

		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateSysRoleByNullChk(SysRole entity) {
		SQL sql = new SQL().UPDATE("sys_role");
					if(!Strings.isNullOrEmpty(entity.getRoleDesc())) {sql.SET("role_desc = #{roleDesc}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("sys_role");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String findNameById(Integer id) {
		SQL sql = new SQL().SELECT("role_desc as roleDesc").FROM("sys_role");
		sql.WHERE(" id=#{id}");
		return sql.toString();
	}
	
}
