package com.moka.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
   /**
   * 获取现在时间
   * @return 返回字符串格式 yyyyMMddHHmmss
   */

	public static String getStringShortDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString =formatter.format(date);
		return dateString;
	}
}
