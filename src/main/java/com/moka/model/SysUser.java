package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 用户user表
 * modle
 */
@Setter
@Getter
	public class SysUser extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  username;//登录账号名称
	private String  password;//密码
	private String  name;//员工姓名
	private String  mobile;//员工手机号
	private String  picture;//员工头像
	private String  birthday;//员工出生年月
	private Integer userEnable;//用户状态0：禁用，1正常
	private Integer userId;//录入人id



	
}
