package com.nhnacademy.project.gateway.task.controller;

import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;

    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "main/index";
    }

    @GetMapping("/project/{projectId}")
    public String getAllTasksByProjectId(@PathVariable Integer projectId, RedirectAttributes redirectAttributes) {
        List<Task> taskList = taskService.getTasksByProjectId(projectId);
        redirectAttributes.addFlashAttribute("project", projectService.getProject(projectId));
        if (!taskList.isEmpty()) {
            redirectAttributes.addFlashAttribute("taskList", taskList);
        }
        return "redirect:/project";
    }


    @GetMapping("/{taskId}")
    public String getTask(Model model, @PathVariable("taskId") Integer taskId) {
        model.addAttribute("tasks", taskService.getTask(taskId));
        return "main/index";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
    }

}

