package com.nhnacademy.project.gateway.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.project.account")
@Data
public class UserAdaptorProperties {
    @NotNull
    private String address;
}
