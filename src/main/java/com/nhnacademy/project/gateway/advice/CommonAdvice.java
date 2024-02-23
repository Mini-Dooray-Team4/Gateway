package com.nhnacademy.project.gateway.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@ControllerAdvice
public class CommonAdvice {
    @ExceptionHandler(HttpClientErrorException.Conflict.class)
    public String conflictHandler(HttpClientErrorException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "redirect:/users/signup";
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String notFoundHandler(HttpClientErrorException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "redirect:/users/signup";
    }
}
