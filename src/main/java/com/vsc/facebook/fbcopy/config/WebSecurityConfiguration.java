package com.vsc.facebook.fbcopy.config;

import com.vsc.facebook.fbcopy.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Autowired
    public WebSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
//                    .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/register").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .csrf().disable()
                .rememberMe()
                .rememberMeParameter("remember")
                .key("a31239e9-afbd-4a0f-9bac-43f532c12f55")
                .userDetailsService(userService)
                .rememberMeCookieName("rememberMe")
                .tokenValiditySeconds(10000);
    }
}
