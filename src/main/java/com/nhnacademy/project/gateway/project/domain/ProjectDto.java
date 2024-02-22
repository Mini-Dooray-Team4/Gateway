package com.nhnacademy.project.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {
    private Integer projectId;
    private String projectName;
}
