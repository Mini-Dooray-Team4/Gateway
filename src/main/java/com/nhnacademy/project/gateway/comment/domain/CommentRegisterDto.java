package com.nhnacademy.project.gateway.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentRegisterDto {
    private Integer projectId;
    private Integer taskId;
    private String userId;
    private String content;
}