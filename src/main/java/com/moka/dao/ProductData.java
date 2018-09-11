package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.Product;

public interface ProductData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ProductProvider.class, method = "insertProduct")
	@SelectKey(before=false,keyProperty="id",resultType=Long.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertProduct(Product entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ProductProvider.class, method = "selectProductByCount")
	public int selectProductByCount(Product entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ProductProvider.class, method = "selectProductByLimt")
	public List<Product> selectProductByLimt(Product entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ProductProvider.class, method = "selectProduct")
	public List<Product> selectProduct(Product entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ProductProvider.class, method = "selectOne")
	public Product selectOne(long id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ProductProvider.class, method = "updateProduct")
	public int updateProduct(Product entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ProductProvider.class, method = "updateProductByNullChk")
	public int updateProductByNullChk(Product entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ProductProvider.class, method = "deleteProduct")
	public int deleteProduct(long id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ProductProvider.class, method = "deleteByLogic")
	public int deleteByLogic(long id);
}
