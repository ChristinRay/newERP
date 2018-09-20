package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
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
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectSysRoleResourcesByCount(SysRoleResources entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("sys_role_resources");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}
			if(!Objects.isNull(entity.getResourcesId())) {sql.WHERE("resources_id = #{resourcesId}");}

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
	public String selectSysRoleResourcesByLimt(SysRoleResources entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role_resources");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getRoleId())) {sql.WHERE("role_id = #{roleId}");}
			if(!Objects.isNull(entity.getResourcesId())) {sql.WHERE("resources_id = #{resourcesId}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
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
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("sys_role_resources");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateSysRoleResources(SysRoleResources entity) {
		SQL sql = new SQL().UPDATE("sys_role_resources");
				sql.SET("role_id = #{roleId}");
		sql.SET("resources_id = #{resourcesId}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateSysRoleResourcesByNullChk(SysRoleResources entity) {
		SQL sql = new SQL().UPDATE("sys_role_resources");
					if(!Objects.isNull(entity.getRoleId())) {sql.SET("role_id = #{roleId}");}
			if(!Objects.isNull(entity.getResourcesId())) {sql.SET("resources_id = #{resourcesId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteSysRoleResources(long id) {
		SQL sql = new SQL().DELETE_FROM("sys_role_resources");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("sys_role_resources");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
