package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;

    private List<ProjectDto> projects;
    private List<Task> taskList;

    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping
    public String getProjects(Model model) {
        projects = projectService.getProjects();
        model.addAttribute("projects", projects);
        return "main/projects";
    }

    @GetMapping("/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId, RedirectAttributes redirectAttributes) {
        taskList = taskService.getTasksByProjectId(projectId);
        model.addAttribute("project", projectService.getProject(projectId));
        model.addAttribute("projects", projects);
        if (!taskList.isEmpty()) {
            model.addAttribute("taskList", taskList);
        }
        return "main/tasks";
    }

    @GetMapping("/{projectId}/task/{taskId}")
    public String getTask(Model model, @PathVariable("taskId") Integer taskId, @PathVariable("projectId") Integer projectId) {
        model.addAttribute("project", projectService.getProject(projectId));
        model.addAttribute("projects", projects);
        model.addAttribute("taskList", taskList);
        Task task = taskService.getTask(taskId);
        log.info("{}", task);
        model.addAttribute("task", task);
        return "main/taskDetail";
    }

    @PostMapping("/register")
    public String createProject(ProjectRegisterDto projectRegisterDto) {
        projectService.createProject(projectRegisterDto);
        return "redirect:/project";
    }

    @PutMapping("/{projectId}")
    public void updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
    }

}
