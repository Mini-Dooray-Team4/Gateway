package com.nhnacademy.project.gateway.user.adaptor;

import com.nhnacademy.project.gateway.domain.ResponseMessage;
import com.nhnacademy.project.gateway.user.domain.UserDto;

import java.util.List;

public interface UserAdaptor {
    List<UserDto> getUsers();

    UserDto getUser(String userId);

    ResponseMessage createUser(UserDto userDto);


}
