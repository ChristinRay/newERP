package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
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
		SQL sql = new SQL().SELECT("*").FROM("sys_user");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getPassWord())) {sql.WHERE("pass_word = #{passWord}");}
			if(!Objects.isNull(entity.getUserEnable())) {sql.WHERE("user_enable = #{userEnable}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("sys_user");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateSysUser(SysUser entity) {
		SQL sql = new SQL().UPDATE("sys_user");
				sql.SET("user_name = #{userName}");
		sql.SET("pass_word = #{passWord}");
		sql.SET("user_enable = #{userEnable}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
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
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteSysUser(long id) {
		SQL sql = new SQL().DELETE_FROM("sys_user");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("sys_user");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
