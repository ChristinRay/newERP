package com.moka.utils;

 /** 导入列表异常
 *  @author hmm 2018-12-11
 */
public class ListException extends Exception{
	/**
	 * 自动生成版本id
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	public ListException(String code,String message) {
		super();
		this.code=code;
		this.message =message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
