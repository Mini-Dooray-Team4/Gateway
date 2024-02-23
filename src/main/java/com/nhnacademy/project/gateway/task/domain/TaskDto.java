package com.nhnacademy.project.gateway.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDto {
    private Integer taskId;
    private String taskTitle;
    private String userId;
}
