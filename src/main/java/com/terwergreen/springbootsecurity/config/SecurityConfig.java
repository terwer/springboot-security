package com.terwergreen.springbootsecurity.config;

import com.terwergreen.springbootsecurity.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

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

//    @Autowired
//    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //内存中缓存权限数据
        auth.inMemoryAuthentication().withUser("root").password("123456").roles("USER");
        //String encodePassword = passwordEncoder.encode("123456");
        //auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    }

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

