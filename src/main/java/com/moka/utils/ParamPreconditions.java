package com.moka.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.moka.Enum.CodeEnum;
import com.moka.Exception.HandlerException;

/**
* @author    created by lbq
* @date	     2018年9月11日 上午11:01:14
**/
public class ParamPreconditions {


	private static Logger log = LoggerFactory.getLogger(ParamPreconditions.class);

	/**
	 * 字符串为空校验
	 * @param str		待校验字符串
	 * @param code		错误码
	 * @param errMsg	错误信息
	 * @param message	异常信息
	 */
	public static void checkNotEmpty(String str, String code, String errMsg, String message) {
		if(str == null || (str=str.trim()).length() == 0)
			throw new HandlerException(code, errMsg, message);
	}
	/**
	 * 校验字符串数组不能存在空值
	 * @param code		错误码
	 * @param errMsg	错误信息
	 * @param message	异常信息
	 * @param str		待校验字符数组
	 */
	public static void checkNotEmpty(String code, String errMsg, String message, String... str) {
		for(String content : str) {
			if(content == null || (content=content.trim()).length() == 0)
				throw new HandlerException(code, errMsg, message);
		}
	}
	
	/**
	 * 对象为null校验
	 * @param o
	 * @param code
	 * @param errMsg
	 */
	public static void checkNotNull(Object o, String code, String errMsg) {
		if(o == null)
			throw new HandlerException(code, errMsg, errMsg);
	}
	/**
	 * 校验是否满足表达式要求
	 * @param expression
	 * @param code
	 * @param errMsg
	 * @param message
	 */
	public static void checkArgument(boolean expression, String code, String errMsg, String message) {
		if(!expression)
			throw new HandlerException(code, errMsg, message);
	}

	/**
	 * 检查是否不满足表达式要求
	 * @param expression
	 * @param code
	 * @param errMsg
	 */
	public static void checkArgumentNon(boolean expression, String code, String errMsg) {
		if(expression)
			throw new HandlerException(code, errMsg, errMsg);
	}

	/**
	 * 检查是否整数型字符串
	 * @param intStr
	 * @return
	 */
	public static boolean checkIntegerFmt(String intStr){
		log.info("字符串是否为整数intStr:{}",intStr);
		try{
			Integer.parseInt(intStr);
		}catch(Exception e){
			log.error("非整数型字符串intStr:{}",intStr, e);
			return false;
		}
		return true;
	}
	/**
	 * 检查是否为大于等于0的整数型字符串
	 * @param intStr
	 * @return
	 */
	public static boolean checkPositiveIntegerFmt(String intStr){
		log.info("字符串是否为整数intStr:{}",intStr);
		try{
			return Integer.parseInt(intStr) >= 0;
		}catch(Exception e){
			log.error("非整数型字符串intStr:{}",intStr, e);
			return false;
		}
	}
	/**
	 * 校验手机号格式是否正确
	 * @param mobile
	 */
	public static void checkMobileFmt(String mobile, String code, String msg, String message){
		log.info("校验手机号格式是否正确mobile:{}",mobile);
//		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		if(!Pattern.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-8])|(147))\\d{8}$", mobile))
			throw new HandlerException(code, "手机号码格式不正确", "手机号码格式不正确");
	}

	/**
	 * 校验字符串是否只包含字母和数字，且不允许为空串
	 * @param str
	 */
	public static void checkStrByNotEmptyByCN(String str) {
		log.info("验证字符串只包含字母和数字str:{}", str);
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "字符串不能为空");
		if(Pattern.matches("[^a-zA-Z0-9]", str))
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只允许字母和数字");
	}


	/**
	 * 校验字符串是否包含特殊字符，且不允许为空串
	 * @param str
	 */
	public static void checkStrByNotEmptyBySpeC(String str) {
		log.info("校验字符串不包含特殊字符str:{}", str);
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "字符串不能为空");
		if(Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]")
				.matcher(str).find())
			throw new HandlerException(CodeEnum.FAIL.getCode(), "字符串包含特殊字符");
	}
	/**
	 * 校验字符串是否包含不特殊字符，且允许为空串
	 * @param str
	 */
	public static void checkStrBySpeC(String str) {
		log.info("验证字符串不包含特殊字符str:{}", str);
		if(str == null || str.length() == 0)
			return;
		if(Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]")
				.matcher(str).find())
			throw new HandlerException(CodeEnum.FAIL.getCode(), "字符串包含特殊字符");
	}

	/**
	 * 校验字符串是否只包含字母和数字，且不允许为空串
	 * @param str
	 * @param code	返回码
	 * @param msg	返回信息
	 */
	public static void checkStrByNotEmptyByCN(String str, String code, String msg) {
		log.info("验证字符串只包含字母和数字str:{},code:{},msg:{}", str, code, msg);
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "字符串不能为空");
		if(Pattern.matches("[^a-zA-Z0-9]", str))
			throw new HandlerException(code, msg);
	}
	/**
	 * 校验字符串是否只包含字母和数字，且允许为空
	 * @param str
	 * @param code	返回码
	 * @param msg	返回信息
	 */
	public static void checkStrByCN(String str, String code, String msg) {
		log.info("验证字符串只包含字母和数字str:{},code:{},msg:{}", str, code, msg);
		if(str == null || str.length() == 0)
			return;
		if(Pattern.matches("[^a-zA-Z0-9]", str))
			throw new HandlerException(code, msg);
	}

	
	
	/**
	 * 校验字符串是否包含特殊字符，且不允许为空串
	 * @param str
	 * @param code	返回码
	 * @param msg	返回信息
	 */
	public static void checkStrByNotEmptyBySpeC(String str, String code, String msg) {
		log.info("校验字符串不包含特殊字符str:{}", str);
		checkNotEmpty(str, code, msg);
		if(Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]")
				.matcher(str).find())
			throw new HandlerException(code, msg);
	}
	/**
	 * 校验字符串是否包含不特殊字符，且允许为空串
	 * @param str
	 * @param code	返回码
	 * @param msg	返回信息
	 */
	public static void checkStrBySpeC(String str, String code, String msg) {
		log.info("验证字符串不包含特殊字符str:{}", str);
		if(str == null || str.length() == 0)
			return;
		if(Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]")
				.matcher(str).find())
			throw new HandlerException(code, msg);
	}
	
	/**
	 * 校验指定数字是否满足特定位数且大于0
	 * @param number
	 * @param dcimals
	 * @param code
	 * @param msg
	 */
	public static void checkNumberByDecimals(BigDecimal number, int dcimals, String code, String msg) {
		if(number == null || number.compareTo(BigDecimal.ZERO) <= 0 || number.scale() > dcimals)
			throw new HandlerException(code, msg, msg);
	}
	/**
	 * 校验价格保留两位小数且大于0
	 * @param price
	 */
	public static void checkPriceValid(BigDecimal price) {
		checkNumberByDecimals(price, 2, CodeEnum.FAIL.getCode(), "价格保留两位小数且大于0");
	}
	/**
	 * 校验价格保留两位小数且大于0
	 * @param price
	 */
	public static void checkPriceValid(BigDecimal price, String code, String msg) {
		checkNumberByDecimals(price, 2, code, msg);
	}
	/**
	 * 验证是否包含空白字符
	 * @param str
	 */
	public static void checkSpaceExist(String str) {
		for(int i=0;i<str.length();i++) {
			if(Character.isWhitespace(str.charAt(i)))
				throw new HandlerException(CodeEnum.FAIL.getCode(), "不能包含空白字符", "不能包含空白字符");
		}
	}
	/**
	 * 验证是否包含空白字符
	 * @param 	str
	 * @param 	code
	 * @param	msg
	 */
	public static void checkSpaceExist(String str, String code, String msg) {
		for(int i=0;i<str.length();i++) {
			if(Character.isWhitespace(str.charAt(i)))
				throw new HandlerException(code, msg, msg);
		}
	}
	/**
	 * 校验字符串只支持中文、字符和数字
	 * @param str
	 */
	public static void checkStrNotEmptyByChinese(String str) {
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "字符串不能为空");
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式", "只支持中文、字符和数字格式");
	}
	/**
	 * 校验字符串只支持中文、字符和数字
	 * @param str
	 * @param code
	 * @param msg
	 */
	public static void checkStrNotEmptyByChinese(String str, String code, String msg) {
		checkNotEmpty(str, code, msg);
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(code, msg);
	}
	/**
	 * 校验字符串只支持中文、字符和数字且符合特定长度范围
	 * @param min
	 * @param max
	 * @param str
	 */
	public static void checkStrNotEmptyByChinese(int min, int max, String str) {
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【"+min+","+max+"】", "只支持中文、字符和数字格式【"+min+","+max+"】");
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【"+min+","+max+"】", "只支持中文、字符和数字格式【"+min+","+max+"】");
		if(str.length() < min || str.length() > max)
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【"+min+","+max+"】", "只支持中文、字符和数字格式【"+min+","+max+"】");
	}
	/**
	 * 校验字符串只支持中文、字符和数字且符合特定长度范围
	 * @param min
	 * @param max
	 * @param str
	 * @param code
	 * @param msg
	 */
	public static void checkStrNotEmptyByChinese(int min, int max, String str, String code, String msg) {
		checkNotEmpty(str, code, msg);
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(code, msg);
		if(str.length() < min || str.length() > max)
			throw new HandlerException(code, msg);
	}
	/**
	 * 校验字符串只支持中文、字符和数字且符合1-15个字符
	 * @param str
	 * @param code
	 * @param msg
	 */
	public static void checkStrNotEmptyByChinese15Len(String str, String code, String msg) {
		checkNotEmpty(str, code, msg);
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(code, msg);
		if(str.length() < 1 || str.length() > 15)
			throw new HandlerException(code, msg);
	}
	/**
	 * 校验字符串只支持中文、字符和数字且符合1-15个字符
	 * @param str
	 */
	public static void checkStrNotEmptyByChinese15Len(String str) {
		checkNotEmpty(str, CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【1,15】", "只支持中文、字符和数字格式【1,15】");
		if(!str.matches("^[a-z0-9A-Z\u4e00-\u9fa5]+$"))
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【1,15】", "只支持中文、字符和数字格式【1,15】");
		if(str.length() < 1 || str.length() > 15)
			throw new HandlerException(CodeEnum.FAIL.getCode(), "只支持中文、字符和数字格式【1,15】", "只支持中文、字符和数字格式【1,15】");
	}

	public static int randomForInt(int min, int max) {
		return (int) (min + Math.random() * (max-min+1));
	}
	public static String randomForInt2Str(int min, int max) {
		int random = randomForInt(min, max);
		String result = String.valueOf(random);
		int i = String.valueOf(max).length() - result.length();
		for(int j=0;j<i;j++) {
			result = "0" + result;
		}
		return result;
	}

	public static String toJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	public static <E> E fromJson(String jsonObj, Class<E> c) {
		Gson gson = new Gson();
		return gson.fromJson(jsonObj, c);
	}

}
