package com.pt.config;

import com.pt.service.LoginIdPwValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginIdPwValidator loginIdPwValidator;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/board/**").hasRole("USER")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/user/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                .failureUrl("/user/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/user/login")
                    .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "Idea-61b2fb57")
                    .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/asserts/**", "/css/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(loginIdPwValidator).passwordEncoder(passwordEncoder());
    }

}
