package com.nhnacademy.project.gateway.user.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum UserStatus {
    JOIN,LEAVE,DORMANT;

    @JsonCreator
    public static UserStatus from(String userStatus) {
        return Arrays.stream(UserStatus.values())
                .filter(status -> status.toString().equals(userStatus.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
