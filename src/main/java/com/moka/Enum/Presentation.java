package com.moka.Enum;
/**
 * 诉单 情况说明
 * @author GENG CHANG WEI
 *
 */
public enum Presentation {

	GOODS_RECEIVED_BROKEN("1","收到商品破碎"),
	GOODS_NOT_RECEIVED("2","未收到商品"),
	ADDRESS_IS_UNKNOWN("3","地址不详");
	
	private String code;
	private String msg;
	Presentation(String code, String msg) {
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
		for (Presentation presentation : Presentation.values()) {
			if (msg.trim().equals(presentation.getMsg())) {
				return presentation.getCode();
			}
		}
		return null;
	}
	
}
