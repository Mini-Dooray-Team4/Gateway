package com.nhnacademy.project.gateway.comment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.project.comment")
@Data
public class CommentAdaptorProperties {
    @NotNull
    private String address;
}
