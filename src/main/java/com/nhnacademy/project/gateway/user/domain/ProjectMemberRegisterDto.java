package com.nhnacademy.project.gateway.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectMemberRegisterDto {
    private Integer projectId;
    private List<String> userId;
}
