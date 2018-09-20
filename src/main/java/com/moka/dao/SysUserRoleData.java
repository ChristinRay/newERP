package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.SysUserRole;
@Mapper
public interface SysUserRoleData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = SysUserRoleProvider.class, method = "insertSysUserRole")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertSysUserRole(SysUserRole entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "selectSysUserRoleByCount")
	public int selectSysUserRoleByCount(SysUserRole entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "selectSysUserRoleByLimt")
	public List<SysUserRole> selectSysUserRoleByLimt(SysUserRole entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "selectSysUserRole")
	public List<SysUserRole> selectSysUserRole(SysUserRole entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysUserRoleProvider.class, method = "selectOne")
	public SysUserRole selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserRoleProvider.class, method = "updateSysUserRole")
	public int updateSysUserRole(SysUserRole entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserRoleProvider.class, method = "updateSysUserRoleByNullChk")
	public int updateSysUserRoleByNullChk(SysUserRole entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = SysUserRoleProvider.class, method = "deleteSysUserRole")
	public int deleteSysUserRole(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserRoleProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
