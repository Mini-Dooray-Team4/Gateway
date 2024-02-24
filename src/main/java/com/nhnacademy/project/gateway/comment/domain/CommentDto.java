package com.nhnacademy.project.gateway.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentDto {
    private String userId;
    private String content;
    private LocalDateTime createAt;
}
