package com.nhnacademy.project.gateway.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.project")
@Data
public class ProjectAdaptorProperties {
    @NotNull
    private String address;
}
