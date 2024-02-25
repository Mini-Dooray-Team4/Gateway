package com.nhnacademy.project.gateway.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String userName;
    private String userEmail;
}
