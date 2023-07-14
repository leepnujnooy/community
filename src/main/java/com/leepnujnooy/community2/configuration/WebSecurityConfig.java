package com.leepnujnooy.community2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authHttp -> authHttp
                                .requestMatchers("/users/login","/users/signup").permitAll()
                                .requestMatchers("/users/main","/users/logout").authenticated()
                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/users/login")
                                .defaultSuccessUrl("/users/main")
                                .failureUrl("/users/login?fail")
                )
                .logout(
                        logOut -> logOut
                                .logoutUrl("/users/logout")
                                .logoutSuccessUrl("/users")
                );
        return httpSecurity.build();
    }
}
