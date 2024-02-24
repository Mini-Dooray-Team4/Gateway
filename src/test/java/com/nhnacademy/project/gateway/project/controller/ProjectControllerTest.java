package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.task.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProjects() {
//        mockMvc.perform(get(""))
    }

    @Test
    void getProject() {
    }

    @Test
    void getTask() {
    }

    @Test
    void createProject() {
    }

    @Test
    void updateProject() {
    }

    @Test
    void deleteProject() {
    }
}