package com.terwergreen.springbootsecurity.controller.admin;

import com.terwergreen.springbootsecurity.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Terwer
 * @Date 2018/6/22 16:17
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping(Constants.adminPrefix)
public class AdminController {

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
