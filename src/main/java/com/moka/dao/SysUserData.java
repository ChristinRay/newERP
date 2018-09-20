package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
	public List<SysUser> selectSysUser(SysUser entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = SysUserProvider.class, method = "selectOne")
	public SysUser selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserProvider.class, method = "updateSysUser")
	public int updateSysUser(SysUser entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserProvider.class, method = "updateSysUserByNullChk")
	public int updateSysUserByNullChk(SysUser entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = SysUserProvider.class, method = "deleteSysUser")
	public int deleteSysUser(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = SysUserProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
