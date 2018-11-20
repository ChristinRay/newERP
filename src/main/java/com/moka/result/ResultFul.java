package com.moka.result;

import java.util.List;

/**
* @author    created by lbq
* @date	     2018年4月6日 下午3:35:39
**/
public class ResultFul {
	private String code;
	private String msg;
	private List<?> ts;
	
	
	public List<?> getTs() {
		return ts;
	}
	public void setTs(List<?> ts) {
		this.ts = ts;
	}
	public ResultFul(String code, String msg) {
		this.code=code;
		this.msg=msg;
	}
	public static ResultFul create(String code,String msg){
		return new ResultFul(code,msg);
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
	public ResultFul(String code,List<?> ts) {
		this.code=code;
		this.ts=ts;
	}
	public static ResultFul create2(String code,List<?> list){
		return new ResultFul(code,list);
	}
	
	
}
