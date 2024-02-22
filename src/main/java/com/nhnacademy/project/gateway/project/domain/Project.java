package com.nhnacademy.project.gateway.project.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Integer projectId;

    private String userId;

    private String projectName;

    private String projectState;

}