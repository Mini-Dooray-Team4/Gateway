package com.nhnacademy.project.gateway.task.adapter;

import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;

import java.util.List;

public interface TaskAdaptor {
    List<TaskDto> getAllTasks();
    List<Task> getAllTasksByProjectId(Integer projectId);

    TaskDto getTask(Integer taskId);

    void createTask(Task task);

    void updateTask(Task task);

    void deleteTask(Integer taskId);
}
