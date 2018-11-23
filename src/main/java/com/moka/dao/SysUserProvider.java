package com.moka.dao;

import java.util.Objects;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.google.common.base.Strings;
import com.moka.model.SysUser;


/**
 * 用户user表
 * provider
 */

public class SysUserProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysUser(SysUser entity) {
		SQL sql = new SQL().INSERT_INTO("sys_user");
		sql.VALUES("user_name,pass_word,user_enable", "#{userName},#{passWord},#{userEnable}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectSysUserByCount(SysUser entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("sys_user");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getPassWord())) {sql.WHERE("pass_word = #{passWord}");}
			if(!Objects.isNull(entity.getUserEnable())) {sql.WHERE("user_enable = #{userEnable}");}
			
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
	public String selectSysUserByLimt(SysUser entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_user");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getPassWord())) {sql.WHERE("pass_word = #{passWord}");}
			if(!Objects.isNull(entity.getUserEnable())) {sql.WHERE("user_enable = #{userEnable}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysUser(SysUser entity) {
		SQL sql = new SQL().SELECT("id as id ,user_name as userName,pass_word as passWord,user_enable as userEnable").FROM("sys_user");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getPassWord())) {sql.WHERE("pass_word = #{passWord}");}
			if(!Objects.isNull(entity.getUserEnable())) {sql.WHERE("user_enable = #{userEnable}");}
			System.out.println(sql+"&&&&&&&&&&&&");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateSysUserByNullChk(SysUser entity) {
		SQL sql = new SQL().UPDATE("sys_user");
					if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.SET("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getPassWord())) {sql.SET("pass_word = #{passWord}");}
			if(!Objects.isNull(entity.getUserEnable())) {sql.SET("user_enable = #{userEnable}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id") int id) {
		SQL sql = new SQL().UPDATE("sys_user");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 根据userId得到user下的权限
	 * @param entity
	 * @return
	 */
	public String findPermissionsByUserId(@Param("id") int id) {
		SQL sql = new SQL().SELECT("c.res_url").FROM(" sys_user_role a INNER JOIN sys_role_resources b on (a.role_id=b.role_id) INNER JOIN sys_resources c ON(b.resources_id=c.id)");
				sql.WHERE(" a.user_id = #{id}");
		return sql.toString();
	}
}











