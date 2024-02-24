package com.nhnacademy.project.gateway.project.service;

import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {
    @Autowired
    ProjectService projectService;

    @Test
    void getProjects() {
        List<ProjectDto> projects = projectService.getProjects();
        assertThat(projects.size()).isEqualTo(1);
    }

    @Test
    void getProject() {
        ProjectDto project = projectService.getProject(1);
        assertThat(project.getProjectName()).isEqualTo("ㄹㄹㄹ");
    }
}