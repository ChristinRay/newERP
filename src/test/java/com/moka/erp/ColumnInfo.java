package com.moka.erp;

import java.util.List;

import com.google.common.collect.Lists;
import lombok.Data;

/**
 * 
 * @author  created by lbq
 * @date    2018年9/11
 */
@Data
public class ColumnInfo {

	private String table = "";
	private String tableComment = "";
	private String tableClasse = "";
	private String primaryKey = "";
	
	private List<String> columns = Lists.newArrayList();  //表列名
	private List<String> columnsType = Lists.newArrayList();
	private String columnsStr = "";//列名，以，分割，不含id
	private List<String> properties = Lists.newArrayList();  //实体类属性名
	private List<String> propertyErs = Lists.newArrayList();  //mybatis格式属性
	private String propertyErsStr = ""; //mybatis属性格式字符串，不含id
	private List<String> propTypes = Lists.newArrayList();  //实体类属性类型名
	private String propWhereStr = "";
	private String propSetStr = "";
	private String propWhereSetStr = "";
	private List<String> propImports = Lists.newArrayList();  //import字符串数组
	private String propImportsStr = ""; //属性import字符串
	private String propFieldDefStr = ""; //类属性定义字符串
	private String propMethodDefStr = ""; //类方法定义字符串
	private List<String> columnComments = Lists.newArrayList();  //字段注释

	
}
