package com.nhnacademy.project.gateway.user.controller;

import com.nhnacademy.project.gateway.user.adaptor.UserAdaptorImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserAdaptorImpl userAdaptor;

    public UserController(UserAdaptorImpl userAdaptor) {
        this.userAdaptor = userAdaptor;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userAdaptor.getUsers());
        return "main/index";
    }
}
