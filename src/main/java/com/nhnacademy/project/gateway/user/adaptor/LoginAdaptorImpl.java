package com.nhnacademy.project.gateway.user.adaptor;

import com.nhnacademy.project.gateway.user.config.LoginAdaptorProperties;
import com.nhnacademy.project.gateway.user.config.UserAdaptorProperties;
import com.nhnacademy.project.gateway.user.domain.LoginDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginAdaptorImpl implements LoginAdaptor{
    private final RestTemplate restTemplate;
    private final LoginAdaptorProperties loginAdaptorProperties;
    private final String address;

    public LoginAdaptorImpl(RestTemplate restTemplate,LoginAdaptorProperties loginAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.loginAdaptorProperties = loginAdaptorProperties;
        this.address = loginAdaptorProperties.getAddress();
    }

    @Override
    public UserDto matches(LoginDto loginDto) {
        ResponseEntity<UserDto> exchange = restTemplate.postForEntity(
                address,
                loginDto,
                UserDto.class
                );
        return exchange.getBody();
    }
}
