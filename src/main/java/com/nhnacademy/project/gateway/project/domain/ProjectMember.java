package com.nhnacademy.project.gateway.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMember {
//    private Project project;
    private Integer projectId;
    private String userId;
}
