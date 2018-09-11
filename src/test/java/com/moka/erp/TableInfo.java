package com.moka.erp;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 
 * @author  created by boming
 * @date    2018年3月1日 下午3:44:28
 */
public class TableInfo {

	private List<String> tables = Lists.newArrayList();
	private List<String> tablesComments = Lists.newArrayList();
	private List<String> tableClasses = Lists.newArrayList();
	public List<String> getTables() {
		return tables;
	}
	public void setTables(List<String> tables) {
		this.tables = tables;
	}
	public List<String> getTablesComments() {
		return tablesComments;
	}
	public void setTablesComments(List<String> tablesComments) {
		this.tablesComments = tablesComments;
	}
	public List<String> getTableClasses() {
		return tableClasses;
	}
	public void setTableClasses(List<String> tableClasses) {
		this.tableClasses = tableClasses;
	}
	
}
