package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysResources;
@Mapper
public interface SysResourcesData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysResourcesProvider.class, method = "insertSysResources")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysResources(SysResources entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysResourcesProvider.class, method = "selectSysResourcesByCount")
	public int selectSysResourcesByCount(SysResources entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = SysResourcesProvider.class, method = "selectSysResourcesByLimt")
	public List<SysResources> selectSysResourcesByLimt(SysResources entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysResourcesProvider.class, method = "selectSysResources")
	public List<SysResources> selectSysResources(SysResources entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysResourcesProvider.class, method = "selectOne")
	public SysResources selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysResourcesProvider.class, method = "updateSysResources")
	public int updateSysResources(SysResources entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysResourcesProvider.class, method = "updateSysResourcesByNullChk")
	public int updateSysResourcesByNullChk(SysResources entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = SysResourcesProvider.class, method = "deleteSysResources")
	public int deleteSysResources(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysResourcesProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
