package com.moka.erp;

import java.util.List;

import com.google.common.collect.Lists;
import lombok.Data;

/**
 * 
 * @author  created by boming
 * @date    2018年3月1日 下午3:44:28
 */
@Data
public class TableInfo {

	private List<String> tables = Lists.newArrayList();
	private List<String> tablesComments = Lists.newArrayList();
	private List<String> tableClasses = Lists.newArrayList();
	
}
