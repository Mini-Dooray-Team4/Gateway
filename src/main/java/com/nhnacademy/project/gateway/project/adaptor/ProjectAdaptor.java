package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectModifyDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;

import java.util.List;

public interface ProjectAdaptor {
    List<ProjectDto> getProjects();

    ProjectDto getProject(Integer projectId);

    void createProject(ProjectRegisterDto projectRegisterDto);

    void updateProject(ProjectModifyDto projectModifyDto);

    void deleteProject(Integer projectId);
}
