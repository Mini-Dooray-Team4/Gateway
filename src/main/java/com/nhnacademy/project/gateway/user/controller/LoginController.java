package com.nhnacademy.project.gateway.user.controller;

import com.nhnacademy.project.gateway.user.adaptor.LoginAdaptor;
import com.nhnacademy.project.gateway.user.domain.LoginDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private final LoginAdaptor loginAdaptor;

    public LoginController(LoginAdaptor loginAdaptor) {
        this.loginAdaptor = loginAdaptor;
    }

    @GetMapping("/login")
    public String loginForm() {

        return "auth/loginForm";
    }

    @PostMapping("/login")
    public String doLogin(LoginDto loginDto, HttpServletRequest request) {
        UserDto userDto = loginAdaptor.matches(loginDto);
        if (Objects.isNull(userDto)) {
            return "redirect:/auth/login";
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userDto);
        return "redirect:/project";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
