package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.config.ProjectAdaptorProperties;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
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

    /*
            public UserAdaptorImpl(RestTemplate restTemplate,UserAdaptorProperties userAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.userAdaptorProperties = userAdaptorProperties;
        this.address = userAdaptorProperties.getAddress();
    }

    @Override
    public List<UserDto> getUsers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }

    @Override
    public UserDto getUser(String userId) {
        ResponseEntity<UserDto> exchange = restTemplate.getForEntity(
                address+"/{id}",
                UserDto.class,
                userId
        );
        return exchange.getBody();
    }

    @Override
    public ResponseMessage createUser(UserDto userDto) {
        ResponseEntity<ResponseMessage> exchange = restTemplate.postForEntity(
                address,
                userDto,
                ResponseMessage.class
        );
        return exchange.getBody();
    }
     */

    @Override
    public List<ProjectDto> getProjects() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }

    @Override
    public ProjectDto getProject(Integer projectId) {
        ResponseEntity<ProjectDto> exchange = restTemplate.getForEntity(
                address + "/{id}",
                ProjectDto.class,
                projectId
        );
        return exchange.getBody();
    }

    @Override
    public void createProject(Project project) {
        restTemplate.postForEntity(
                address,
                project,
                Void.class
        );
    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void deleteProject(Project project) {

    }
}
