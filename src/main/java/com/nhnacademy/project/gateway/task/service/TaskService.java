package com.nhnacademy.project.gateway.task.service;

import com.nhnacademy.project.gateway.task.adapter.TaskAdaptor;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskDto;
import com.nhnacademy.project.gateway.task.domain.TaskRegisterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskAdaptor taskAdaptor;

    public TaskService(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    public List<TaskDto> getTasks() {
        return taskAdaptor.getAllTasks();
    }

    public List<Task> getTasksByProjectId(Integer projectId) {
        return taskAdaptor.getAllTasksByProjectId(projectId);
    }

    public Task getTask(Integer taskId) {
        return taskAdaptor.getTask(taskId);
    }

    public void createTask(TaskRegisterDto taskRegisterDto) {
        taskAdaptor.createTask(taskRegisterDto);
    }

    public void updateTask(Task task) {
        taskAdaptor.updateTask(task);
    }

    public void deleteTask(Integer taskId) {
        taskAdaptor.deleteTask(taskId);
    }

}
