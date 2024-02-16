package com.zech.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.naming.NoPermissionException;
import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                        .requestMatchers("/notices", "/contact","/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                )
                .httpBasic(AbstractHttpConfigurer::disable
                );


        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        //Approach 1
//        UserDetails admin= User.withUsername("admin")
//                .password("1234")
//                .authorities("admin")
//                .build();
//        UserDetails user=User.withUsername("user")
//                .password("1234")
//                .authorities("user")
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);
////        Approach 2
////        InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
////        UserDetails admin= User.withUsername("admin") .password("1234") .authorities("admin").build();
////        UserDetails user= User.withUsername("user") .password("1234").authorities("user").build();
////        inMemoryUserDetailsManager.createUser(admin);
////        inMemoryUserDetailsManager.createUser(user);
////        return  inMemoryUserDetailsManager;
//    }
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }


}
