package com.nhnacademy.project.account.domain;

import com.nhnacademy.project.gateway.user.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
