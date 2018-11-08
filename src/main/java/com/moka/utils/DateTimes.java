package com.moka.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
* @author    created by lbq
* @date	     2018年11月7日 下午6:21:46
**/
public class DateTimes {


    public static final String TIMESTAMP_PATTERN = "yyyyMMddHHmmssSSS";
    public static final String DATE_PATTERN = "yyyyMMdd";
    public static final String DATE_STYLE = "yyyyMMdd HHmmss";
    public static final String TIME_PATTERN = "HHmmss";

    public static final String TIMESTAMP_PATTERN2 = "yyyyMMdd HHmmss";
    public static final String TIMESTAMP_PATTERN3 = "yyyyMMddHHmmss";
    public static final String TIMESTAMP_PATTERN4 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN2 = "yyyy-MM-dd";
    public static final String DATE_PATTERN3 = "yyyy年M月d日";
    public static final String[] DATE_PATTERN_ARY = new String[]{TIMESTAMP_PATTERN, DATE_PATTERN,
            TIMESTAMP_PATTERN2, DATE_PATTERN2, DATE_PATTERN3};
    private static long MINUTE_IN_MILLISECOND = 60 * 1000;
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    
    public static final String timestamp(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN));
    }

    public static final String getDateStr(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_STYLE));
    }

    public static final String nowTimestamp() {
        return timestamp(LocalDateTime.now());
    }

    public static final String date(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static final Date date() {
        return new Date();
    }

    public static final String nowDate() {
        return date(LocalDate.now());
    }

    public static final String nowDate2() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN2));
    }

    public static final String time(LocalTime time) {
        return time.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
    }

    public static final String nowTime() {
        return date(LocalDate.now());
    }

    public static final String nowDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN4));
    }

    public static final String nowDateTimetrim() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN3));
    }

    public static final Date parse(String dateStr, String[] pattern) {
        try {
            return DateUtils.parseDateStrictly(dateStr, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public static final String nowTimestamp(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static final String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    public static final String format(String dateStr, String pattern) {
        return DateFormatUtils.format(parse(dateStr, DATE_PATTERN_ARY), pattern);
    }

    /**
     * 字符串形式转化为Date类型
     * String类型按照format格式转为Date类型
     **/
    public static Date fromStringToDate(String format, String dateTime) throws ParseException {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = sdf.parse(dateTime);
        return date;
    }

    /**
     * 简单转换日期类型到字符串类型，本地信息设为UK
     *
     * @param date
     * @param format
     * @return String
     */
    public static String getFomartDate(Date date, String format) {
        try {
            return new SimpleDateFormat(format, Locale.UK).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return (date == null) ? new Date().toString() : date.toString();
        }
    }

    public static String addMinuteToStringDate(String formate, String strDate, long minutes) {
        String stringDate = null;
        try {
            Date date = fromStringToDate(formate, strDate);
            long now = date.getTime() + minutes * MINUTE_IN_MILLISECOND;

            stringDate = getFomartDate(new Date(now), formate);

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return stringDate;
    }
	/**
	 * 字符串转换为日期:不支持yyM[M]d[d]格式
	 * 
	 * @param date
	 * @return
	 */
	public static final Date stringToDate(String date) {
		if (date == null) {
			return null;
		}
		String separator = String.valueOf(date.charAt(4));
		String pattern = "yyyyMMdd";
		if (!separator.matches("\\d*")) {
			pattern = "yyyy" + separator + "MM" + separator + "dd";
			if (date.length() < 10) {
				pattern = "yyyy" + separator + "M" + separator + "d";
			}
		} else if (date.length() < 8) {
			pattern = "yyyyMd";
		}
		pattern += " HH:mm:ss.SSS";
		pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 将指定格式的字符串转换为日期型
	 *
	 * @param strDate
	 *            - 日期
	 * @param oracleFormat
	 *            --oracle型日期格式
	 * @return 转换得到的日期
	 */
	public static Date stringToDate(String strDate, String oracleFormat) {
		if (strDate == null)
			return null;
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		String javaFormat = new String();
		String s = oracleFormat.toLowerCase();
		if (s.indexOf("yyyy") != -1)
			h.put(new Integer(s.indexOf("yyyy")), "yyyy");
		else if (s.indexOf("yy") != -1)
			h.put(new Integer(s.indexOf("yy")), "yy");
		if (s.indexOf("mm") != -1)
			h.put(new Integer(s.indexOf("mm")), "MM");

		if (s.indexOf("dd") != -1)
			h.put(new Integer(s.indexOf("dd")), "dd");
		if (s.indexOf("hh24") != -1)
			h.put(new Integer(s.indexOf("hh24")), "HH");
		if (s.indexOf("mi") != -1)
			h.put(new Integer(s.indexOf("mi")), "mm");
		if (s.indexOf("ss") != -1)
			h.put(new Integer(s.indexOf("ss")), "ss");

		int intStart = 0;
		while (s.indexOf("-", intStart) != -1) {
			intStart = s.indexOf("-", intStart);
			h.put(new Integer(intStart), "-");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf("/", intStart) != -1) {
			intStart = s.indexOf("/", intStart);
			h.put(new Integer(intStart), "/");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(" ", intStart) != -1) {
			intStart = s.indexOf(" ", intStart);
			h.put(new Integer(intStart), " ");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(":", intStart) != -1) {
			intStart = s.indexOf(":", intStart);
			h.put(new Integer(intStart), ":");
			intStart++;
		}

		if (s.indexOf("年") != -1)
			h.put(new Integer(s.indexOf("年")), "年");
		if (s.indexOf("月") != -1)
			h.put(new Integer(s.indexOf("月")), "月");
		if (s.indexOf("日") != -1)
			h.put(new Integer(s.indexOf("日")), "日");
		if (s.indexOf("时") != -1)
			h.put(new Integer(s.indexOf("时")), "时");
		if (s.indexOf("分") != -1)
			h.put(new Integer(s.indexOf("分")), "分");
		if (s.indexOf("秒") != -1)
			h.put(new Integer(s.indexOf("秒")), "秒");

		int i = 0;
		while (h.size() != 0) {
			Enumeration<Integer> e = h.keys();
			int n = 0;
			while (e.hasMoreElements()) {
				i = e.nextElement().intValue();
				if (i >= n)
					n = i;
			}
			String temp = h.get(new Integer(n));
			h.remove(new Integer(n));

			javaFormat = temp + javaFormat;
		}
		SimpleDateFormat df = new SimpleDateFormat(javaFormat);

		Date myDate = new Date();
		try {
			myDate = df.parse(strDate);
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

		return myDate;
	}
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date) {
		return format(date, DATE_PATTERN2);
	}
	public static final boolean validYMDate1(String dateString){
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		boolean dateflag=true;
		try
		{
			Date date = format.parse(dateString);
		} catch (ParseException e)
		{
			dateflag=false;
		}
		return dateflag;
	}
	public static final boolean validYMDate(String dateString){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		boolean dateflag=true;
		try
		{
			Date date = format.parse(dateString);
		} catch (ParseException e)
		{
			dateflag=false;
		}
		return dateflag;
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static final String getDate() {
		return format(new Date());
	}

	/**
	 * 获取日期时间
	 * 
	 * @return
	 */
	public static final String getDateTime() {
		return format(new Date(), TIMESTAMP_PATTERN4);
	}

	/**
	 * 获取日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static final String getDateTime(String pattern) {
		return format(new Date(), pattern);
	}

	/**
	 * 日期计算
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public static final Date addDate(Date date, int field, int amount) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 字符串转换为日期:不支持yyM[M]d[d]格式
	 * 
	 * @param date
	 * @return
	 */
	public static final Date stringToDate1(String date) {
		if (date == null) {
			return null;
		}
		String separator = String.valueOf(date.charAt(4));
		String pattern = "yyyyMMdd";
		if (!separator.matches("\\d*")) {
			pattern = "yyyy" + separator + "MM" + separator + "dd";
			if (date.length() < 10) {
				pattern = "yyyy" + separator + "M" + separator + "d";
			}
		} else if (date.length() < 8) {
			pattern = "yyyyMd";
		}
		pattern += " HH:mm:ss.SSS";
		pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getDayBetween(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		end.set(Calendar.HOUR_OF_DAY, 0);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);

		long n = end.getTimeInMillis() - start.getTimeInMillis();
		return (int) (n / (60 * 60 * 24 * 1000l));
	}

	/**
	 * 间隔月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetween(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		return n;
	}
	/**
	 * 得到当前日期，格式yyyy-MM-dd。
	 * @return String 格式化的日期字符串
	 */
	public static String getYesterday()
	{
		Date cDate = new Date();
		cDate.setTime(cDate.getTime() - 24 * 3600 * 1000);
		SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return cSimpleDateFormat.format(cDate);
	}
	/**
	 * 间隔月，多一天就多算一个月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		int day1 = start.get(Calendar.DAY_OF_MONTH);
		int day2 = end.get(Calendar.DAY_OF_MONTH);
		if (day1 <= day2) {
			n++;
		}
		return n;
	}

}
