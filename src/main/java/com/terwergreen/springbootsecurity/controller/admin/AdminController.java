package com.terwergreen.springbootsecurity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Terwer
 * @Date 2018/6/22 16:17
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("workspace")
    public String register() {
        return "workspace/workspace_index";
    }

    @RequestMapping("user")
    public String userIndex() {
        return "user/user_index";
    }
}
