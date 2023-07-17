package com.leepnujnooy.community2.controller;

import com.leepnujnooy.community2.entity.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserUIController {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String loginView(){
        return "loginview";
    }

    @GetMapping("/main")
    public String mainView(){
        return "mainview";
    }

    @GetMapping("/signup")
    public String signUpView(){
        return "signupview";
    }

    @PostMapping("/signup")
    public String signUpReq(@RequestParam("username")String username, @RequestParam("password")String password){

        userDetailsManager.createUser(CustomUserDetails
                        .builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .build());

        return "redirect:/users/login";
    }
}