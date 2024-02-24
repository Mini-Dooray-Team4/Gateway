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

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;


    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping
    public String getProjects(Model model, HttpSession session) {
        List<ProjectDto> projects = projectService.getProjects();
        session.setAttribute("projects", projects);
        return "main/projects";
    }

    @GetMapping("/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId, HttpSession session) {
        List<Task> taskList = taskService.getTasksByProjectId(projectId);
        session.setAttribute("project", projectService.getProject(projectId));
        session.setAttribute("taskList", taskList);
        return "main/tasks";
    }

    @GetMapping("/{projectId}/task/{taskId}")
    public String getTask(Model model, @PathVariable("taskId") Integer taskId, @PathVariable("projectId") Integer projectId) {
        Task task = taskService.getTask(taskId);
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
