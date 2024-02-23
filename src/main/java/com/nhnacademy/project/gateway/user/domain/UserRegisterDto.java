package com.nhnacademy.project.gateway.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    @NotBlank
    private String userId;

    @Length(min = 3, max = 30)
    @NotBlank
    private String userPassword;


    @NotBlank
    private String userName;

    @NotBlank
    private String userEmail;

}
