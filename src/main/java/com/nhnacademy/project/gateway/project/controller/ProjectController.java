package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.project.adaptor.ProjectAdaptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
