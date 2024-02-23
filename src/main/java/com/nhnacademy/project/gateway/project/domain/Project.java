package com.nhnacademy.project.gateway.project.domain;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
    private Integer projectId;

    private String userId;

    private String projectName;

    private String projectState;
}