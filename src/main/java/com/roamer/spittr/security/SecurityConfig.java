package com.roamer.spittr.security;

import com.roamer.spittr.dao.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置
 * <p>
 * 使用@EnableWebSecurity(Spring4时@EnableWebMvcSecurity已弃用)注解将会启用Web安全功能。但它本身并没有什么用处，
 * Spring Security必须配置在一个实现了WebSecurityConfigurer的bean中，
 * 或者扩展WebSecurityConfigurerAdapter。
 * 在Spring应用上下文中，任何实现了WebSecurityConfigurer的bean都可以用来配置Spring Security
 * </p>
 *
 * @author roamer
 * @version V1.0
 * @date 2018/1/17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpitterRepository spitterRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //AuthenticationManagerBuilder有多个方法可以用来配置Spring Security对认证的支持。
        auth.userDetailsService(new UserDetailsServiceImpl(spitterRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //formLogin()启用默认登录界面
                .formLogin().loginPage("/login")
                .and()
                //Remember-me功能，你只要登录过一次,回到应用的时候你就不需要登录了
                //存储在cookie中的token包含用户名、密码、过期时间和一个私钥,在写入cookie前都进行了MD5哈希
                .rememberMe().tokenValiditySeconds(200).key("spittrKey")
                .and()
                //关闭跨站攻击防御
                .csrf().disable()
                .authorizeRequests()
                //authenticated()和permitAll()定义该如何保护路径。
                //authenticated()要求在执行该请求时，必须已经登录了应用。
                //如果用户没有认证的话，Spring Security的Filter将会捕获该请求，并将用户重定向到应用的登录页面。
                //同时， permitAll()方法允许请求没有任何的安全限制。
                .antMatchers("/spitters/me").hasRole("SPITTER")
                .antMatchers("/spittles").hasRole("USER")
                .and()
                //requiresChannel()这个方法能够为各种URL模式声明所要求的通道
                .requiresChannel()
                .antMatchers("/spitter/form").requiresInsecure();

    }
}
