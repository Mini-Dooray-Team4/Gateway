package com.nhnacademy.project.gateway.task.adapter;

import com.nhnacademy.project.gateway.domain.ResponseMessage;
import com.nhnacademy.project.gateway.task.config.TaskAdaptorProperties;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;
import com.nhnacademy.project.gateway.user.domain.UserDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TaskAdaptorImpl implements TaskAdaptor {

    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties properties;
    private final String address;

    public TaskAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.address = properties.getAddress();
    }

    @Override
    public List<TaskDto> getAllTasks() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TaskDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return exchange.getBody();
    }

    @Override
    public TaskDto getTask(Integer taskId) {
        ResponseEntity<TaskDto> exchange = restTemplate.getForEntity(
                address+"/{id}",
                TaskDto.class,
                taskId
        );
        return exchange.getBody();
    }


    // 나중에 Task 프로젝트에서 create, delete, update 메소드 수정 필요
    @Override
    public ResponseMessage createTask(TaskDto taskDto) {
        ResponseEntity<ResponseMessage> exchange = restTemplate.postForEntity(
                address,
                taskDto,
                ResponseMessage.class
        );
        return exchange.getBody();
    }
}
