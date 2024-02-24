package com.nhnacademy.project.gateway.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer commentId;

    @Length(min = 3, max = 20)
    @NotBlank
    private String userId;

    private Integer projectId;

    private Integer taskId;

    @Length(min = 1, max = 200)
    @NotBlank
    private String content;

    @NotBlank
    private LocalDateTime createAt;

}
