package com.nhnacademy.project.gateway.task.service;

import com.nhnacademy.project.gateway.task.domain.TaskDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    TaskService taskService;

    @Test
    void getTasks() {
        List<TaskDto> tasks = taskService.getTasks();
        Assertions.assertThat(tasks.size()).isEqualTo(5);
    }

    @Test
    void getTasksByProjectId() {
    }

    @Test
    void getTask() {
    }
}