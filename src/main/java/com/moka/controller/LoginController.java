package com.moka.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.moka.model.SysUser;
import com.moka.req.UserReq;
import com.moka.result.Result;
import com.moka.result.ResultFul;
import com.moka.service.SysRoleService;

import lombok.extern.slf4j.Slf4j;
/**
* @author    created by lbq
* @date	     2018年9月20日 下午4:15:43
**/
@RestController
@RequestMapping("/api/erp/v1/user")
@Slf4j
public class LoginController {
	@Autowired
	private SysRoleService sysRoleService;

    @PostMapping("/login")
    public Result<?> submitLogin(@RequestBody UserReq req, HttpServletRequest request) {
		SysUser user;
    	UsernamePasswordToken token = new UsernamePasswordToken(req.getUsername(), req.getPassword());
    	Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            user= (SysUser) subject.getPrincipal();
            //PrincipalCollection asd= subject.getPreviousPrincipals();//得到登录人的所有权限
        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            return Result.create("ERROR", "账户已被禁用");
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            return Result.create("ERROR", "用户名或密码错误");
        }
        Map<String, Object> map=Maps.newLinkedHashMap();
        map.put("session", subject.getSession().getId());
        map.put("userId",user.getId());
        Set<String> resUrl= sysRoleService.findRoleNameByUserId(user.getId());
        map.put("resUrl", resUrl);
        map.put("username", user.getUsername());//登录
        
        // 执行到这里说明用户已登录成功
        return Result.create(map);
    }
    
    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public ResultFul logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        log.info("已退出");
        return ResultFul.create("OK", "已退出");
    }
    

    @GetMapping( "/unauth")
    public ResultFul loginPage() {
    	log.info("测试登录");
        return ResultFul.create("ERROR", "请重新登录！");
    }

//    @PostMapping("/index")
//    public String loginSuccessMessage(HttpServletRequest request) {
//        String username = "未登录";
//        SysUser currentLoginUser = RequestUtils.currentLoginUser();
//
//        if (currentLoginUser != null && StringUtils.isNotEmpty(currentLoginUser.getUserName())) {
//            username = currentLoginUser.getUserName();
//        } else {
//            return "redirect:/auth/login";
//        }
//        request.setAttribute("username", username);
//        return "index";
//    }

    //被踢出后跳转的页面
    @GetMapping("/kickout")
    public ResultFul kickOut() {
        return ResultFul.create("ERROR", "您的账号已在别处登录！");
    }
    
}
