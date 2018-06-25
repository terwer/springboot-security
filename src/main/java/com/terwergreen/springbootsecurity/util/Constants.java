package com.terwergreen.springbootsecurity.util;

/**
 * @Author Terwer
 * @Date 2018/6/22 16:41
 * @Version 1.0
 * @Description TODO
 **/
public class Constants {
    /**
     * 后台管理后缀
     */
    public static final String adminPrefix = "a";
    /**
     * 后台管理地址通配符
     */
    public static final String adminUrlPattern = "/" + Constants.adminPrefix + "/**";
    /**
     * api地址通配符
     */
    public static final String apiUrlPattern = "/" + Constants.adminPrefix + "/**";
    /**
     * 登录页面
     */
    public static final String loginPage = "/" + Constants.adminPrefix + "/login";
    /**
     * 处理地址
     */
    public static final String loginProcessingUrl = "/" + Constants.adminPrefix + "/signin";
    /**
     * 退出登录地址
     */
    public static final String logoutUrl = "/" + Constants.adminPrefix + "/login?logout";
    /**
     * 验证错误地址
     */
    public static final String failureUrl = "/" + Constants.adminPrefix + "/login?error";
}
