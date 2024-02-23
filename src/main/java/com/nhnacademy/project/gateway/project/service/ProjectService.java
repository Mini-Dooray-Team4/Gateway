package com.nhnacademy.project.gateway.project.service;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectAdaptor projectAdaptor;

    public ProjectService(ProjectAdaptor projectAdaptor) {
        this.projectAdaptor = projectAdaptor;
    }

    public List<ProjectDto> getProjects() {
        return projectAdaptor.getProjects();
    }

    public ProjectDto getProject(Integer projectId) {
        return projectAdaptor.getProject(projectId);
    }

    public void createProject(Project project) {
        projectAdaptor.createProject(project);
    }

    public void updateProject(Project project){
        projectAdaptor.updateProject(project);
    }

    public void deleteProject(Integer projectId){
        projectAdaptor.deleteProject(projectId);
    }

}
