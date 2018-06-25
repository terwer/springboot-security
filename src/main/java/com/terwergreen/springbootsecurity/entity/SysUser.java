package com.terwergreen.springbootsecurity.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author Terwer
 * @Date 2018/6/25 12:02
 * @Version 1.0
 * @Description TODO
 **/
@Getter
@Setter
public class SysUser {
    private Integer id;
    private String username;
    private String password;

    private List<SysRole> roles;
}
