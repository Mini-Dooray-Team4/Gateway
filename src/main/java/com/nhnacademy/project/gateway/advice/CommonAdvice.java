package com.nhnacademy.project.gateway.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.project.gateway.domain.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@ControllerAdvice
public class CommonAdvice {
    @ExceptionHandler(HttpClientErrorException.Conflict.class)
    public String conflictHandler(HttpClientErrorException e, Model model) {
        MessageDto messageDto = new MessageDto("이미 존재하는 회원입니다!", "/user/signup", RequestMethod.GET, null);
        model.addAttribute("params", messageDto);
        return "common/messageRedirect";
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String notFoundHandler(HttpClientErrorException e, Model model) {
        MessageDto messageDto = new MessageDto("아이디 비밀번호를 확인해주세요!", "/auth/login", RequestMethod.GET, null);
        model.addAttribute("params", messageDto);
        return "common/messageRedirect";
    }
}
