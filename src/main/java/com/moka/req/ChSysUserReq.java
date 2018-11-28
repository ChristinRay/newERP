package com.moka.req;

import java.util.Set;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月27日 下午5:27:19
**/
@Data
public class ChSysUserReq {
	private String  username;//登录账号名称
	private String  password;//密码
	private String  name;//员工姓名
	private String  mobile;//员工手机号
	private String  picture;//员工头像
	private String  birthday;//员工出生年月
	private Integer userEnable;//用户状态0：禁用，1正常
	private Integer userId;//录入人id
	private Set<Integer> roles;//角色id
}
