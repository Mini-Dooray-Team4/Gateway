package com.nhnacademy.project.gateway.comment.controller;

import com.nhnacademy.project.gateway.comment.domain.CommentRegisterDto;
import com.nhnacademy.project.gateway.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Slf4j
@Controller
@RequestMapping("/project/{projectId}/task/{taskId}/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String getComments(Model model,
                              @PathVariable("projectId") Integer projectId,
                              @PathVariable("taskId") Integer taskId){
        model.addAttribute("comments", commentService.getComments(projectId, taskId));
        return HttpStatus.OK.toString();
    }

    @GetMapping("/{commentId}")
    public String getComment(Model model,
                             @PathVariable("commentId") Integer commentId,
                             @PathVariable("projectId") Integer projectId,
                             @PathVariable("taskId") Integer taskId){
        commentService.getComment(commentId, projectId, taskId);
        return HttpStatus.OK.toString();
    }

    @PostMapping
    public void createComment(@RequestBody CommentRegisterDto commentRegisterDto){
        commentService.createComment(commentRegisterDto);
    }

    @PutMapping("/{commentId}")
    public void updateComment(@RequestBody CommentRegisterDto commentRegisterDto,
                              @PathVariable("commentId") Integer commentId){
        commentService.updateComment(commentRegisterDto, commentId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Integer commentId){
        commentService.deleteComment(commentId);
    }


}
