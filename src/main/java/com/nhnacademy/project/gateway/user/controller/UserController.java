package com.nhnacademy.project.gateway.user.controller;

import com.nhnacademy.project.gateway.user.adaptor.UserAdaptor;
import com.nhnacademy.project.gateway.user.adaptor.UserAdaptorImpl;
import com.nhnacademy.project.gateway.user.domain.UserRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserAdaptor userAdaptor;

    public UserController(UserAdaptorImpl userAdaptor) {
        this.userAdaptor = userAdaptor;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userAdaptor.getUsers());
        return "main/index";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(UserRegisterDto userRegisterDto) {
        userAdaptor.createUser(userRegisterDto);
        return "redirect:/login";
    }
}
