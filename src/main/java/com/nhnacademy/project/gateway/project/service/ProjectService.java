package com.nhnacademy.project.gateway.project.service;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectModifyDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.user.domain.ProjectMemberRegisterDto;
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

    public void createProject(ProjectRegisterDto projectRegisterDto) {
        projectAdaptor.createProject(projectRegisterDto);
    }

    public void updateProject(ProjectModifyDto projectModifyDto){
        projectAdaptor.updateProject(projectModifyDto);
    }

    public void deleteProject(Integer projectId){
        projectAdaptor.deleteProject(projectId);
    }

    public void inviteProjectMember(ProjectMemberRegisterDto projectMemberRegisterDto) {
        projectAdaptor.inviteProjectMember(projectMemberRegisterDto);

    }

}
