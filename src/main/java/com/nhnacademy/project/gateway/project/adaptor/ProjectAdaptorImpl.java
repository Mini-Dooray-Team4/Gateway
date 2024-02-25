package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.config.ProjectAdaptorProperties;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectModifyDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.user.domain.ProjectMemberRegisterDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProjectAdaptorImpl implements ProjectAdaptor {
    private final RestTemplate restTemplate;
    private final ProjectAdaptorProperties projectAdaptorProperties;
    private final String address;

    public ProjectAdaptorImpl(RestTemplate restTemplate, ProjectAdaptorProperties projectAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.projectAdaptorProperties = projectAdaptorProperties;
        this.address = projectAdaptorProperties.getAddress();
    }

    @Override
    public List<ProjectDto> getProjects(UserDto user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.add("userId",user.getUserId());
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() { // 본문을 List<ProjectDto> 형태로 매핑
                });

        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }

        return exchange.getBody();
    }

    @Override
    public ProjectDto getProject(Integer projectId) {
        ResponseEntity<ProjectDto> exchange = restTemplate.getForEntity(
                address + "/{projectId}",
                ProjectDto.class, // response type
                projectId);
        return exchange.getBody();
    }

    @Override
    public void createProject(ProjectRegisterDto projectRegisterDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectRegisterDto, project);
        restTemplate.postForEntity(
                address,
                project, // request
                Void.class // response type
        );
    }

    @Override
    public void updateProject(ProjectModifyDto projectModifyDto) {
        restTemplate.put(
                address + "/{projectId}",
                projectModifyDto, // request
                projectModifyDto.getProjectId());
    }

    @Override
    public void deleteProject(Integer projectId) {
        restTemplate.delete(
                address + "/{projectId}",
                projectId);
    }

    @Override
    public void inviteProjectMember(ProjectMemberRegisterDto projectMemberRegisterDto) {
        restTemplate.postForEntity(
                address+"/{projectId}/member/invite",
                projectMemberRegisterDto,
                Void.class,
                projectMemberRegisterDto.getProjectId()
        );
    }
}
