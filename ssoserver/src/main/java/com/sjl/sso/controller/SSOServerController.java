package com.sjl.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjl.sso.MockDatabaseUtil;

import java.util.UUID;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */

@Controller
public class SSOServerController {

    @RequestMapping("/checkLogin")
    public String checkLogin(String redirectUrl, HttpSession session,
                             Model model){
        //判断是否有全局会话
        String token = (String) session.getAttribute("token");
        if(StringUtils.isEmpty(token)){
            //没有全局会话
            //跳转到统一认证中心
            model.addAttribute("redirectUrl",redirectUrl);
            return "/login";
        }else {
            //有全局会话
        	System.out.println("有会话");
            return "/logout";
        }
    }
    /**
     *   login
     * 
     * @param username
     * @param password
     * @param redirectUrl
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password,String redirectUrl,HttpSession session,
    		Model model) {
    	System.out.println(username +password);
    	if(StringUtils.isNoneEmpty(username) && StringUtils.isNoneEmpty(password) &&
    			"zhangsan".equals(username) && "123".equals(password)) {
    		
    		System.out.println("123  zhangsan");
    		//账号密码匹配
    		//创建令牌信息
    		String token = UUID.randomUUID().toString();
    		//创建全局会话，将令牌放入会话
    		session.setAttribute("token", token);
    		//将令牌信息存入数据库
    		MockDatabaseUtil.T_TOKEN.add(token);
    		//重定向到redirectUrl，并且携带令牌信息
//    		return "redirect:"+redirectUrl+"?token="+token;
    		model.addAttribute("token", token);
    		return "redirect:"+redirectUrl;
    	}else {
    		System.out.println("账号密码不正确");
        	model.addAttribute("redirectUrl",redirectUrl);
        	return "login";
		}
    	
    }
    /**
     * 校验令牌是否由统一认证中心产生的
     * 
     * @param token
     * @return
     */
    @RequestMapping("/versify")
    @ResponseBody
    public String verifyToken(String token) {
    	if(MockDatabaseUtil.T_TOKEN.contains(token)) {
    		return "true";
    	}else {
    		return"false";
		}
    	
    }
   
}
