package com.sjl.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
            return "";
        }
    }
}
