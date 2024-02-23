package com.nhnacademy.project.gateway.task.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.project.task")
@Data
public class TaskAdaptorProperties {
    @NotNull
    private String address;
}
