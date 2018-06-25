/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.terwergreen.springbootsecurity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Terwer
 * @Date 2018/6/25 15:07
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("auth")
public class AuthController {

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
