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
package com.terwergreen.springbootsecurity.controller.home;

import com.terwergreen.springbootsecurity.common.dto.RestResponseDTO;
import com.terwergreen.springbootsecurity.common.dto.RestResponseStates;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Terwer
 * @Date 2018/6/22 16:19
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("/")
public class HomePageController {
    @RequestMapping("/")
    public String home(Model model) {
        RestResponseDTO restResponseDTO = new RestResponseDTO(RestResponseStates.SUCCESS.getValue(), RestResponseStates.SUCCESS.getMsg(), "操作成功");
        model.addAttribute("msg", restResponseDTO);
        return "themes/default/index";
    }
}
