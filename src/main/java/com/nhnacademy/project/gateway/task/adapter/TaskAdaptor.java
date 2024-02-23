package com.nhnacademy.project.gateway.task.adapter;

import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;
import com.nhnacademy.project.gateway.task.domain.TaskRegisterDto;

import java.util.List;

public interface TaskAdaptor {
    List<TaskDto> getAllTasks();
    List<Task> getAllTasksByProjectId(Integer projectId);

    Task getTask(Integer taskId);

    void createTask(TaskRegisterDto taskRegisterDto);

    void updateTask(Task task);

    void deleteTask(Integer taskId);
}
