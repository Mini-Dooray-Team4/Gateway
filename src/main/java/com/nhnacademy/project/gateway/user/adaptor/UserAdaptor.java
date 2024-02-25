package com.nhnacademy.project.gateway.user.adaptor;

import com.nhnacademy.project.gateway.user.domain.UserDto;
import com.nhnacademy.project.gateway.user.domain.UserRegisterDto;

import java.util.List;

public interface UserAdaptor {
    List<UserDto> getUsers();

    UserDto getUser(String userId);

    void createUser(UserRegisterDto userRegisterDto);


}
