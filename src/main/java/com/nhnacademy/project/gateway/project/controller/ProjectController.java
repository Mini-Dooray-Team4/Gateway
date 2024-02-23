package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectAdaptor projectAdaptor;

    public ProjectController(ProjectAdaptor projectAdaptor) {
        this.projectAdaptor = projectAdaptor;
    }

    @GetMapping
    public String getProjects(Model model) {
        model.addAttribute("projects", projectAdaptor.getProjects());

        return "main/index";
    }

    @GetMapping("/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId, RedirectAttributes redirectAttributes) {
        ProjectDto project = projectAdaptor.getProject(projectId);
        redirectAttributes.addFlashAttribute("project", project);
        log.info("{}",project);
        return "redirect:/project";
    }
}
