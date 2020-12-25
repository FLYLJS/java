package com.controller;

import com.domain.User;
import com.service.impl.UserServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("say")
    public String say(Model model){
        model.addAttribute("user",userService.findAll());
        JSONArray jsonArray =JSONArray.fromObject(userService.findAll());
        model.addAttribute("jsonArray",jsonArray);
        return "user";
    }
    @RequestMapping("save")
    public String save(String username,Integer age,Double money,String address,String phone, Model model){
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        user.setAddress(address);
        user.setMoney(money);
        user.setPhone(phone);
        userService.saveUser(user);
        model.addAttribute("success","保存用户");
        return "success";
    }

}
