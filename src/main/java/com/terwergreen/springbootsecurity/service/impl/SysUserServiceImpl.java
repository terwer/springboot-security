package com.terwergreen.springbootsecurity.service.impl;

import com.terwergreen.springbootsecurity.common.dao.CommonDAO;
import com.terwergreen.springbootsecurity.entity.SysRole;
import com.terwergreen.springbootsecurity.entity.SysUser;
import com.terwergreen.springbootsecurity.service.SysUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Terwer
 * @Date 2018/6/25 13:49
 * @Version 1.0
 * @Description 自定义UserDetailsService 接口
 **/
public class SysUserServiceImpl implements SysUserService {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private CommonDAO commonDAO;

    /**
     * 重写loadUserByUsername 方法获得 userdetails 类型用户
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = (SysUser) commonDAO.querySingleByString("selectByUserName", username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities就万事大吉。
        for (SysRole role : sysUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            logger.info("role：" + role.getName());
        }
        User user = new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
        return user;
    }
}
