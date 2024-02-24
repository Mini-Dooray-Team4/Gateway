package com.nhnacademy.project.gateway.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRegisterDto {
    private Integer projectId;
    private String taskTitle;
    private String userId;
    private String taskContent;
}
