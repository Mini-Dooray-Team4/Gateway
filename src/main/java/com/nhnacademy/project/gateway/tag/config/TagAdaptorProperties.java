package com.nhnacademy.project.gateway.tag.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.project.tag")
@Data
public class TagAdaptorProperties {
    @NotNull
    private String address;
}
