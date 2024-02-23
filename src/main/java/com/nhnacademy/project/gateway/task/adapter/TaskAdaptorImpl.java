package com.nhnacademy.project.gateway.task.adapter;

import com.nhnacademy.project.gateway.task.config.TaskAdaptorProperties;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;
import com.nhnacademy.project.gateway.task.domain.TaskRegisterDto;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
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
    public List<Task> getAllTasksByProjectId(Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Task>> exchange = restTemplate.exchange(
                address + "/project/{projectId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {},
                projectId
        );
        return exchange.getBody();
    }

    @Override
    public Task getTask(Integer taskId) {
        ResponseEntity<Task> exchange = restTemplate.getForEntity(
                address+"/{id}",
                Task.class,
                taskId
        );
        return exchange.getBody();
    }

    @Override
    public void createTask(TaskRegisterDto taskRegisterDto) {

        restTemplate.postForEntity(
                address,
                taskRegisterDto,
                TaskRegisterDto.class
        );
    }

    @Override
    public void updateTask(Task task) {
        restTemplate.put(
                address + "/{taskId}",
                task,
                task.getTaskId()
        );
    }

    @Override
    public void deleteTask(Integer taskId) {
        restTemplate.delete(
                address + "/{taskId}",
                taskId
        );
    }
}
