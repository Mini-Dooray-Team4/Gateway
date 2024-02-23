package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        return "main/index";
    }

    @GetMapping("/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId) {
        model.addAttribute("projects", projectService.getProject(projectId));
        return "main/index";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@RequestBody Project project){
        projectService.createProject(project);
    }

    @PutMapping("/{projectId}")
    public void updateProject(@RequestBody Project project){
        projectService.updateProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable("projectId") Integer projectId){
        projectService.deleteProject(projectId);
    }


}
