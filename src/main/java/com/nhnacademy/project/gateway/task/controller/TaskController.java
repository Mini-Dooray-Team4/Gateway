package com.nhnacademy.project.gateway.task.controller;

import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.domain.TaskRegisterDto;
import com.nhnacademy.project.gateway.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
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
        return "main/index";
    }


    @GetMapping("/{taskId}/project/{projectId}")
    public String getTask(Model model, @PathVariable("taskId") Integer taskId, @PathVariable("projectId") Integer projectId) {
        List<Task> taskList = taskService.getTasksByProjectId(projectId);
        model.addAttribute("project", projectService.getProject(projectId));
        if (!taskList.isEmpty()) {
            model.addAttribute("taskList", taskList);
        }
        Task task = taskService.getTask(taskId);
        model.addAttribute("task", task);
        return "main/taskDetail";
    }

    @PostMapping("/register")
    public String createTask(TaskRegisterDto taskRegisterDto, @RequestParam("projectId") Integer projectId, RedirectAttributes redirectAttributes) {
        taskService.createTask(taskRegisterDto);
        redirectAttributes.addFlashAttribute("project", projectService.getProject(projectId));
        return "redirect:/project/" + projectId;
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

