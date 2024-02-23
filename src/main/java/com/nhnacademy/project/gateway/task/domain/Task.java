package com.nhnacademy.project.gateway.task.domain;

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
    private Project project;
    private String userId;
    private String taskTitle;
    private String taskContent;
    private LocalDateTime createAt;
}
