package com.terwergreen.springbootsecurity.config;

import com.terwergreen.springbootsecurity.util.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Terwer
 * @Date 2018/6/22 15:55
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Configuration
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/error",
                    "/webjars/**",
                    "/favicon.ico",
                    Constants.adminUrlPattern,
                    "/index.html"
            );
            super.configure(web);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(Constants.adminUrlPattern, Constants.apiUrlPattern)
                    .authenticated()
                    .and()
                    .exceptionHandling()
//                    .authenticationEntryPoint(authenticationEntryPoint())
                    .and().httpBasic()
                    .and()
                    .formLogin()
//                    .loginPage(Constants.loginPage)
                    .permitAll()
//                    .loginProcessingUrl(Constants.loginProcessingUrl)
//                    .successHandler(loginSuccessHandler)
//                    .failureHandler(ajaxSimpleUrlAuthenticationFailureHandler)
                    .and()
                    .logout()
//                    .logoutUrl(Constants.logoutUrl)
                    .permitAll()
//                    .logoutSuccessHandler(logoutSuccessHandler())
                    .and()
                    .rememberMe()
//                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(1209600)
                    .and()
                    .csrf()
                    .disable();
            super.configure(http);
        }
    }
}

