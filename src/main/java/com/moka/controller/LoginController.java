package com.moka.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.SysUser;
import com.moka.result.Result;
import com.moka.result.ResultFul;

/**
* @author    created by lbq
* @date	     2018年9月20日 下午4:15:43
**/
@RestController
@RequestMapping("/api/erp/v1/user")
public class LoginController {

    @PostMapping("/login")
    public Result<?> submitLogin(String username, String password, HttpServletRequest request) {
    	SysUser user;
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            user= (SysUser) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            return Result.create("ERROR", "账户已被禁用");
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            return Result.create("ERROR", "用户名或密码错误");
        }

        // 执行到这里说明用户已登录成功
        return Result.create(user);
    }
    
    

    @GetMapping( "/login")
    public String loginPage() {
        return "login";
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
    public String kickOut() {
        return "kickout";
    }
    
}
