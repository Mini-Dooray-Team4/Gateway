package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectModifyDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.user.domain.ProjectMemberRegisterDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;

import java.util.List;

public interface ProjectAdaptor {
    List<ProjectDto> getProjects(UserDto user);

    ProjectDto getProject(Integer projectId);

    void createProject(ProjectRegisterDto projectRegisterDto);

    void updateProject(ProjectModifyDto projectModifyDto);

    void deleteProject(Integer projectId);

    void inviteProjectMember(ProjectMemberRegisterDto projectMemberRegisterDto);
}
