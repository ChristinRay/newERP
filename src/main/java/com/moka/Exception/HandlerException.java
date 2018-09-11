package com.moka.Exception;
/**
* @author    created by lbq
* @date	     2018年9月11日 上午11:04:33
**/
public class HandlerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	public HandlerException(){
		super();
	}
	public HandlerException(String message){
		super(message);
	}
	public HandlerException(Throwable t){
		super(t);
	}
	public HandlerException(String message, Throwable t){
		super(message,t);
	}
	public HandlerException(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	public HandlerException(String code, String msg, String message){
		super(message);
		this.code = code;
		this.msg = msg;
	}
	public HandlerException(String code, String msg, String message, Throwable t){
		super(message, t);
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
