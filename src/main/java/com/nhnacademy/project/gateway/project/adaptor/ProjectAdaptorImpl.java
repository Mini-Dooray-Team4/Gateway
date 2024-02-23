package com.nhnacademy.project.gateway.project.adaptor;

import com.nhnacademy.project.gateway.project.config.ProjectAdaptorProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProjectAdaptorImpl implements ProjectAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectAdaptorProperties projectAdaptorProperties;
    public ProjectAdaptorImpl(RestTemplate restTemplate, ProjectAdaptorProperties projectAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.projectAdaptorProperties = projectAdaptorProperties;
    }
}
