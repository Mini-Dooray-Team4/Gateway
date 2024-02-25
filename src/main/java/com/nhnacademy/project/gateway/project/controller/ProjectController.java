package com.nhnacademy.project.gateway.project.controller;

import com.nhnacademy.project.gateway.comment.domain.CommentDto;
import com.nhnacademy.project.gateway.comment.service.CommentService;
import com.nhnacademy.project.gateway.project.domain.Project;
import com.nhnacademy.project.gateway.project.domain.ProjectDto;
import com.nhnacademy.project.gateway.project.domain.ProjectModifyDto;
import com.nhnacademy.project.gateway.project.domain.ProjectRegisterDto;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.task.domain.Task;
import com.nhnacademy.project.gateway.task.service.TaskService;
import com.nhnacademy.project.gateway.user.domain.ProjectMemberRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final CommentService commentService;


    public ProjectController(ProjectService projectService, TaskService taskService, CommentService commentService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.commentService = commentService;
    }

    @GetMapping
    public String getProjects(Model model, HttpSession session) {
        List<ProjectDto> projects = projectService.getProjects();
        session.getAttribute("user");
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
        List<CommentDto> commentList = commentService.getComments(projectId, taskId);
        model.addAttribute("task", task);
        log.info("{}",commentList);
        model.addAttribute("commentList", commentList);
        return "main/taskDetail";
    }

    @PostMapping("/register")
    public String createProject(ProjectRegisterDto projectRegisterDto) {
        projectService.createProject(projectRegisterDto);
        return "redirect:/project";
    }

    @PostMapping("/modify/{projectId}")
    public String updateProject(ProjectModifyDto projectModifyDto) {
        log.info("{}",projectModifyDto);
        projectService.updateProject(projectModifyDto);
        return "redirect:/project";
    }

    @PostMapping("/{projectId}/member/invite")
    public String inviteProjectMember(HttpServletRequest request,ProjectMemberRegisterDto projectMemberRegisterDto) {
        log.info("{}",projectMemberRegisterDto);
        projectService.inviteProjectMember(projectMemberRegisterDto);

        return "redirect:/project";
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
    }

}
