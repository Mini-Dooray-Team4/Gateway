package com.nhnacademy.project.gateway.comment.service;

import com.nhnacademy.project.gateway.comment.adaptor.CommentAdaptor;
import com.nhnacademy.project.gateway.comment.domain.CommentDto;
import com.nhnacademy.project.gateway.comment.domain.CommentRegisterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentAdaptor commentAdaptor;

    public CommentService(CommentAdaptor commentAdaptor) {
        this.commentAdaptor = commentAdaptor;
    }

    public List<CommentDto> getComments(Integer projectId, Integer taskId){
        return commentAdaptor.getComments(projectId, taskId);
    }

    public CommentDto getComment(Integer commentId, Integer projectId, Integer taskId){
        return commentAdaptor.getComment(commentId, projectId, taskId);
    }

    public void createComment(CommentRegisterDto commentRegisterDto){
        commentAdaptor.createComment(commentRegisterDto);
    }

    public void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId){
        commentAdaptor.updateComment(commentRegisterDto, commentId);
    }

    public void deleteComment(Integer commentId){
        commentAdaptor.deleteComment(commentId);
    }
}
