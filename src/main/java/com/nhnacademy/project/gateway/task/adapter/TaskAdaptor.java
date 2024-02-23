package com.nhnacademy.project.gateway.task.adapter;

import com.nhnacademy.project.gateway.domain.ResponseMessage;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;

import java.util.List;

public interface TaskAdaptor {
    List<TaskDto> getAllTasks();

    TaskDto getTask(Integer taskId);

    void createTask(Task task);
}
