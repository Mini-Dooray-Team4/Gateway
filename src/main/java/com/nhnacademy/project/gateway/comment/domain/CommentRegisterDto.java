package com.nhnacademy.project.gateway.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRegisterDto {
    private String userId;
    private String content;
}