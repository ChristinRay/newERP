package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectSysRoleResourcesByCount")
	public int selectSysRoleResourcesByCount(SysRoleResources entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectSysRoleResourcesByLimt")
	public List<SysRoleResources> selectSysRoleResourcesByLimt(SysRoleResources entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectSysRoleResources")
	public List<SysRoleResources> selectSysRoleResources(SysRoleResources entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysRoleResourcesProvider.class, method = "selectOne")
	public SysRoleResources selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleResourcesProvider.class, method = "updateSysRoleResources")
	public int updateSysRoleResources(SysRoleResources entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleResourcesProvider.class, method = "updateSysRoleResourcesByNullChk")
	public int updateSysRoleResourcesByNullChk(SysRoleResources entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = SysRoleResourcesProvider.class, method = "deleteSysRoleResources")
	public int deleteSysRoleResources(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleResourcesProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
