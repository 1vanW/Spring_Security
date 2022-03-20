package com.Ivan.Hohryakov.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

//класс для конфигурации Security
// наследуемся от такого класса
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    //переопределяем такой метод
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
      auth.jdbcAuthentication().dataSource(dataSource);





//        //создаем такой класс c таким статичным методом пречеркнутым
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        // используем методы и задаем такой код с юзерами и их паролями и ролями
//        auth.inMemoryAuthentication().withUser(userBuilder
//                .username("ivan") //логин
//                .password("ivan") //пароль
//                .roles("employee")) //роль
//                .withUser(userBuilder
//                .username("anna")
//                .password("anna")
//                .roles("HR"))
//                .withUser(userBuilder
//                .username("maksim")
//                .password("maksim")
//                .roles("manager","HR"));

    }
    //логика для кнопок что бы не впускать кого попало на другие урл
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE","HR","MANAGER")
                .antMatchers("/hr-info").hasRole("HR")
                .antMatchers("/manager-info").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
