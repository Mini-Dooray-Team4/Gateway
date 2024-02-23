package com.nhnacademy.project.gateway.user.adaptor;

import com.nhnacademy.project.gateway.user.config.UserAdaptorProperties;
import com.nhnacademy.project.gateway.user.domain.UserDto;
import com.nhnacademy.project.gateway.user.domain.UserRegisterDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserAdaptorImpl implements UserAdaptor {
    private final RestTemplate restTemplate;
    private final UserAdaptorProperties userAdaptorProperties;
    private final String address;

    public UserAdaptorImpl(RestTemplate restTemplate, UserAdaptorProperties userAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.userAdaptorProperties = userAdaptorProperties;
        this.address = userAdaptorProperties.getAddress();
    }

    @Override
    public List<UserDto> getUsers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }

    @Override
    public UserDto getUser(String userId) {
        ResponseEntity<UserDto> exchange = restTemplate.getForEntity(
                address + "/{id}",
                UserDto.class,
                userId
        );
        return exchange.getBody();
    }

    @Override
    public void createUser(UserRegisterDto userRegisterDto) {
        restTemplate.postForEntity(
                address,
                userRegisterDto,
                Void.class
        );
    }


}
