package com.moka.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysUser;


@Mapper
public interface SysUserData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysUserProvider.class, method = "insertSysUser")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysUser(SysUser entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysUserProvider.class, method = "selectSysUserByCount")
	public int selectSysUserByCount(SysUser entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = SysUserProvider.class, method = "selectSysUserByLimt")
	public List<SysUser> selectSysUserByLimt(SysUser entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysUserProvider.class, method = "selectSysUser")
	public SysUser selectSysUser(SysUser entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserProvider.class, method = "updateSysUserByNullChk")
	public int updateSysUserByNullChk(SysUser entity);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserProvider.class, method = "deleteByLogic")
	public int deleteByLogic(@Param("id")int id);
	
	/**
	 * 根据登录人id获取登录人权限
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysUserProvider.class, method = "findPermissionsByUserId")
	public Set<String> findPermissionsByUserId(@Param("id")int id);
	
}





















