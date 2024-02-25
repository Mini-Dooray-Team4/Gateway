package com.nhnacademy.project.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Data
@AllArgsConstructor
public class MessageDto {
    private String message;
    private String redirectUri;
    private RequestMethod method;
    private Map<String, Object> data;
}
