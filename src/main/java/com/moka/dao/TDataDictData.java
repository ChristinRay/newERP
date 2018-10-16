package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.annotations.Mapper;
import com.moka.model.TDataDict;

@Mapper
public interface TDataDictData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = TDataDictProvider.class, method = "insertTDataDict")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertTDataDict(TDataDict entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = TDataDictProvider.class, method = "selectTDataDict")
	public List<TDataDict> selectTDataDict(TDataDict entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = TDataDictProvider.class, method = "updateTDataDictByNullChk")
	public int updateTDataDictByNullChk(TDataDict entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = TDataDictProvider.class, method = "deleteTDataDict")
	public int deleteTDataDict(int id);
}
