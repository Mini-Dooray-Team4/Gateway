package com.nhnacademy.project.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer projectId;
    private String userId;
    private String projectName;
    private String projectState;
}
