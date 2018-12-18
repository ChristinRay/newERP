package com.moka.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class LoadProperties {
	private static Logger log =LoggerFactory.getLogger(LoadProperties.class);
	
	public static Map<String,String> propertiesMap =new HashMap<String,String>();
	
	public static String filePath ="config/config.properties";
	
	public static void load() {
		if(StringUtils.isEmpty(filePath)) {
			log.error("The filePath is null");
			return;
		}
		filePath =filePath.trim();
		//从根目录获取资源文件 src/。。。。。
		InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream(filePath);
		// 属性列表
		Properties prop = new Properties();
		
		try {
			//从输入流中读取属性列表
			prop.load(is);
		}catch(IOException e) {
			log.error("load file failure"+e);
			return ;
		}catch(Exception e) {
			log.error("load file failure"+e);
		}finally {
			try {
				is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		//返回Properties中包含的key——value的set视图
		Set<Entry<Object,Object>> set= prop.entrySet();
		//返回在此set元素上进行迭代的迭代器
		Iterator<Map.Entry<Object,Object>> it= set.iterator();
		String key =null;
		String value =null;
		while(it.hasNext()) {
			Entry<Object,Object> entry =it.next();
			key=String.valueOf(entry.getKey());
			value =String.valueOf(entry.getValue());
			key= key ==null?key:key.trim();
			value=value==null?value:value.trim();
		}
		log.info(propertiesMap.toString());
	}
	
	
	

}
