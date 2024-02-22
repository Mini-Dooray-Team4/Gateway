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
    public String ConflictHandler(HttpClientErrorException e, Model model) {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("{}",e.getMessage());
        model.addAttribute("message", e.getMessage());
        return "redirect:/users/signup";
    }
}
