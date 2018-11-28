package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.moka.model.SysResources;

/**
 * 权限表
 * provider
 */
public class SysResourcesProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysResources(SysResources entity) {
		SQL sql = new SQL().INSERT_INTO("sys_resources");
		sql.VALUES("name,res_url,user_type,user_sort", "#{name},#{resUrl},#{userType},#{userSort}");
		return sql.toString();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysResources() {
		SQL sql = new SQL().SELECT("name,res_url as resUrl,user_type as userType").FROM("sys_resources");

		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("sys_resources");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
