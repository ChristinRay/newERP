package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.SysUserRole;

/**
 * 
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
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectSysUserRoleByCount(SysUserRole entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("sys_user_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}

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
	public String selectSysUserRoleByLimt(SysUserRole entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_user_role");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
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
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("sys_user_role");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateSysUserRole(SysUserRole entity) {
		SQL sql = new SQL().UPDATE("sys_user_role");
				sql.SET("user_id = #{userId}");
		sql.SET("role_id = #{roleId}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
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
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteSysUserRole(long id) {
		SQL sql = new SQL().DELETE_FROM("sys_user_role");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("sys_user_role");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
