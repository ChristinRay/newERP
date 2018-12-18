package com.moka.Enum;

import java.util.Map;

import com.google.common.collect.Maps;

/**
* @author    created by lbq
* @date	     2018年12月12日 下午5:41:44
**/
public class CompanyStatic {
	public static Map<Integer, String > map=Maps.newTreeMap();
	
	public static Map<Integer, String> company(){
		map.put(1, "海尔");
		map.put(2, "杏花楼");
		map.put(3, "禾诗");
		map.put(4, "酷家");
		map.put(5, "香山");
		map.put(6, "卡萨帝");
		map.put(7, "illy");
		map.put(8, "哈尔斯");
		map.put(9, "凯俪澜");
		map.put(10, "博客苏");
		map.put(11, "利比");
		map.put(12, "威浩");
		map.put(13, "古方");
		map.put(14, "史努比");
		map.put(15, "知味观");
		map.put(16, "泰格斯");
		map.put(17, "浪莎");
		map.put(18, "北美电器");
		map.put(19, "碧然德");
		map.put(20, "恒源祥");
		map.put(21, "倍尔康");
		map.put(22, "双喜");
		map.put(23, "功德林");
		map.put(24, "金安");
		map.put(25, "派克");
		map.put(26, "雷治");
		map.put(27, "傲胜");
		map.put(28, "北大荒");
		map.put(29, "三胖蛋");
		map.put(30, "remax");
		map.put(31, "徐鸿飞小鲜蛋");
		map.put(32, "John Boss");
		map.put(33, "优胜者");
		map.put(34, "方家铺子");
		map.put(35, "科沃斯");
		map.put(36, "莱克");
		map.put(37, "贝蒂斯");
		return map;
	}
}
