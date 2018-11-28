package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysRole;

import io.lettuce.core.dynamic.annotation.Param;
@Mapper
public interface SysRoleData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysRoleProvider.class, method = "insertSysRole")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysRole(SysRole entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "selectSysRole")
	public List<SysRole> selectSysRole(SysRole entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleProvider.class, method = "updateSysRoleByNullChk")
	public int updateSysRoleByNullChk(SysRole entity);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
	/**
	 * 根据角色id查角色名称
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "findNameById")
	public String findNameById(Integer id);
	
}
