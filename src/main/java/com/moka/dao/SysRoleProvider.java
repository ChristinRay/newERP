package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.SysRole;

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
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectSysRoleByCount(SysRole entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("sys_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getRoleDesc())) {sql.WHERE("role_desc = #{roleDesc}");}

		return sql.toString();
	}
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	public String selectSysRoleByLimt(SysRole entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getRoleDesc())) {sql.WHERE("role_desc = #{roleDesc}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysRole(SysRole entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getRoleDesc())) {sql.WHERE("role_desc = #{roleDesc}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateSysRole(SysRole entity) {
		SQL sql = new SQL().UPDATE("sys_role");
				sql.SET("role_desc = #{roleDesc}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
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
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteSysRole(long id) {
		SQL sql = new SQL().DELETE_FROM("sys_role");
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
}
