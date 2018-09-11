package com.moka.erp;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 
 * @author  created by lbq
 * @date    2018年9/11
 */
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
	
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public List<String> getColumnsType() {
		return columnsType;
	}
	public void setColumnsType(List<String> columnsType) {
		this.columnsType = columnsType;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public String getTableClasse() {
		return tableClasse;
	}
	public void setTableClasse(String tableClasse) {
		this.tableClasse = tableClasse;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public String getColumnsStr() {
		return columnsStr;
	}
	public void setColumnsStr(String columnsStr) {
		this.columnsStr = columnsStr;
	}
	public List<String> getProperties() {
		return properties;
	}
	public void setProperties(List<String> properties) {
		this.properties = properties;
	}
	public List<String> getPropertyErs() {
		return propertyErs;
	}
	public void setPropertyErs(List<String> propertyErs) {
		this.propertyErs = propertyErs;
	}
	public String getPropertyErsStr() {
		return propertyErsStr;
	}
	public void setPropertyErsStr(String propertyErsStr) {
		this.propertyErsStr = propertyErsStr;
	}
	public List<String> getPropTypes() {
		return propTypes;
	}
	public void setPropTypes(List<String> propTypes) {
		this.propTypes = propTypes;
	}
	public String getPropWhereStr() {
		return propWhereStr;
	}
	public void setPropWhereStr(String propWhereStr) {
		this.propWhereStr = propWhereStr;
	}
	public String getPropSetStr() {
		return propSetStr;
	}
	public void setPropSetStr(String propSetStr) {
		this.propSetStr = propSetStr;
	}
	public String getPropWhereSetStr() {
		return propWhereSetStr;
	}
	public void setPropWhereSetStr(String propWhereSetStr) {
		this.propWhereSetStr = propWhereSetStr;
	}
	public List<String> getPropImports() {
		return propImports;
	}
	public void setPropImports(List<String> propImports) {
		this.propImports = propImports;
	}
	public String getPropImportsStr() {
		return propImportsStr;
	}
	public void setPropImportsStr(String propImportsStr) {
		this.propImportsStr = propImportsStr;
	}
	public String getPropFieldDefStr() {
		return propFieldDefStr;
	}
	public void setPropFieldDefStr(String propFieldDefStr) {
		this.propFieldDefStr = propFieldDefStr;
	}
	public String getPropMethodDefStr() {
		return propMethodDefStr;
	}
	public void setPropMethodDefStr(String propMethodDefStr) {
		this.propMethodDefStr = propMethodDefStr;
	}
	public List<String> getColumnComments() {
		return columnComments;
	}
	public void setColumnComments(List<String> columnComments) {
		this.columnComments = columnComments;
	}
	
}
