package com.nhnacademy.project.gateway.user.adaptor;

import com.nhnacademy.project.gateway.user.domain.LoginDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;

public interface LoginAdaptor {
    UserDto matches(LoginDto loginDto);

}
