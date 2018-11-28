package com.moka.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysRoleResources;
@Mapper
public interface SysRoleResourcesData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysRoleResourcesProvider.class, method = "insertSysRoleResources")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysRoleResources(SysRoleResources entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectSysRoleResources")
	public List<SysRoleResources> selectSysRoleResources(SysRoleResources entity);
	
	/**
	 * 查询所有
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectAll")
	public List<SysRoleResources> selectAll();
	
	
	
	
	/**
	 * 查询所有去重的角色
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectRoles")
	public Set<Integer> selectRoles();
	
	
	
	
}
