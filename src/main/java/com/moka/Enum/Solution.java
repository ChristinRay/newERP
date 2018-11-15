package com.moka.Enum;
/**
 * 诉单 解决方案
 * @author GENG CHANG WEI
 *
 */
public enum Solution {

	POSTAL_ISSUE_WRONG("1","邮政问题发错货"),
	POSTAL_ISSUE_MISSING("2","邮政问题丢件"),
	POSTAL_ISSUES("3","邮政问题"),
	REFUND_CUSTOMER("4","给客户退款");
	
	private String code;
	private String msg;
	Solution(String code, String msg) {
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
		for (Solution solution : Solution.values()) {
			if (msg.trim().equals(solution.getMsg())) {
				return solution.getCode();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getCodeByMsg("给客户退款"));
	}
	
}
