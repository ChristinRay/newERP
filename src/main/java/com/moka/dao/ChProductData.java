package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.ChProduct;
@Mapper
public interface ChProductData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChProductProvider.class, method = "insertChProduct")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChProduct(ChProduct entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChProductProvider.class, method = "selectChProductByCount")
	public int selectChProductByCount(ChProduct entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChProductProvider.class, method = "selectChProductByLimt")
	public List<ChProduct> selectChProductByLimt(ChProduct entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChProductProvider.class, method = "selectChProduct")
	public List<ChProduct> selectChProduct(ChProduct entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChProductProvider.class, method = "selectOne")
	public ChProduct selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChProductProvider.class, method = "updateChProduct")
	public int updateChProduct(ChProduct entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChProductProvider.class, method = "updateChProductByNullChk")
	public int updateChProductByNullChk(ChProduct entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChProductProvider.class, method = "deleteChProduct")
	public int deleteChProduct(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChProductProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
