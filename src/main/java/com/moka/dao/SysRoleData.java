package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysRole;
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
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "selectSysRoleByCount")
	public int selectSysRoleByCount(SysRole entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "selectSysRoleByLimt")
	public List<SysRole> selectSysRoleByLimt(SysRole entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "selectSysRole")
	public List<SysRole> selectSysRole(SysRole entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysRoleProvider.class, method = "selectOne")
	public SysRole selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleProvider.class, method = "updateSysRole")
	public int updateSysRole(SysRole entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleProvider.class, method = "updateSysRoleByNullChk")
	public int updateSysRoleByNullChk(SysRole entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = SysRoleProvider.class, method = "deleteSysRole")
	public int deleteSysRole(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysRoleProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
