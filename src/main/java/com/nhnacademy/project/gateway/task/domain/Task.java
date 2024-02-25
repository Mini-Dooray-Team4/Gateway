package com.nhnacademy.project.gateway.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.project.gateway.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Integer taskId;
    private Integer projectId;
    private String userId;
    private String taskTitle;
    private String taskContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
}
