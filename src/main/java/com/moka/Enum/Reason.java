package com.moka.Enum;
/**
 * 诉单 原因
 * @author GENG CHANG WEI
 *
 */
public enum Reason {

	POSTAL_ISSUES("1","邮政问题"),
	POSTAL_DISTRIBUTION_PROBLEM("2","邮政配货问题"),
	POSTAL_LOGISTICS_PROBLEM("3","邮政物流问题"),
	QUALITY_PROBLEMS("4","品质问题"),
	CUSTOMER("5","客户");
	
	private String code;
	private String msg;
	Reason(String code, String msg) {
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
	
	/**
	 * 通过msg得到code
	 * @param msg
	 * @return
	 */
	public static String getCodeByMsg(String msg) {
		for (Reason reason : Reason.values()) {
			if (msg.trim().equals(reason.getMsg())) {
				return reason.getCode();
			}
		}
		return null;
	}
	
}
