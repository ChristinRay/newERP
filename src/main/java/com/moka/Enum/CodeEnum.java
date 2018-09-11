package com.moka.Enum;
/**
* @author    created by lbq
* @date	     2018年9月11日 上午11:11:55
**/
public enum CodeEnum {

	SUCCESS("OK","成功"),
	FAIL("ERROR","系统异常"),
	SESSION_INVLID("SESSION_INVALID","session失效"),
	SESSION_EXPIRED("SESSION_EXPIRED","session过期"),
	SESSION_USER_TYPE_ERR("USER_TYPE_INVALID","无效的用户类型"),
	SESSION_USER_OBTAIN_ERROR("USER_OBTAIN_ERROR", "获取登录用户信息异常");
	
	private String code;
	private String msg;
	CodeEnum(String code, String msg) {
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
