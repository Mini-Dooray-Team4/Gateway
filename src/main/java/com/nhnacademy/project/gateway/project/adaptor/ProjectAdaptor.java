package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.Project;

import java.util.List;

public interface ProjectAdaptor {
    List<ProjectDto> getProjects();

    ProjectDto getProject(Integer projectId);

    void createProject(Project project);

    void updateProject(Project project);

    void deleteProject(Project project);
}
