package com.boot.board_240718.controller;

import com.boot.board_240718.model.User;
import com.boot.board_240718.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    UserService userService;

//  post 방식 호출인데 GetMapping 받음
    @GetMapping("/login")
    public String login(){
        return "/account/login";
    }

    //회원가입
    @GetMapping("/register")
    public String register(){
        //회원가입후 로그인 페이지로 이동
        return "/account/register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        //회원가입후 로그인 페이지로 이동
        return "redirect:/";
    }
}
