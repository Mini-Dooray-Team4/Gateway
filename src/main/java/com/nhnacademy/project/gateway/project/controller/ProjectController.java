package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        log.info("hihi");
        model.addAttribute("projects", projectService.getProjects());
        return "main/index";
    }

    @GetMapping("/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("project", projectService.getProject(projectId));
        return "redirect:/project";
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
