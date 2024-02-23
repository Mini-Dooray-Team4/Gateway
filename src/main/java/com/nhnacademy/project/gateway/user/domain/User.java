package com.nhnacademy.project.gateway.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;

    private String userPassword;
    private String userName;

    private String userEmail;
    private UserStatus userStatus;

}
