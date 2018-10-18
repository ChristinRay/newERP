package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.ChBrand;

@Mapper
public interface ChBrandData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChBrandProvider.class, method = "insertChBrand")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChBrand(ChBrand entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChBrandProvider.class, method = "selectChBrandByCount")
	public int selectChBrandByCount(ChBrand entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChBrandProvider.class, method = "selectChBrandByLimt")
	public List<ChBrand> selectChBrandByLimt(ChBrand entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChBrandProvider.class, method = "selectChBrand")
	public List<ChBrand> selectChBrand(ChBrand entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChBrandProvider.class, method = "selectOne")
	public ChBrand selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChBrandProvider.class, method = "updateChBrand")
	public int updateChBrand(ChBrand entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChBrandProvider.class, method = "updateChBrandByNullChk")
	public int updateChBrandByNullChk(ChBrand entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChBrandProvider.class, method = "deleteChBrand")
	public int deleteChBrand(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChBrandProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
	/**
	 * 查询所有
	 */
	@SelectProvider(type = ChBrandProvider.class, method = "selectChBrandAll")
	public List<ChBrand> selectChBrandAll();
}
