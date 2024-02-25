package com.nhnacademy.project.gateway.comment.adaptor;

import com.nhnacademy.project.gateway.comment.domain.CommentDto;
import com.nhnacademy.project.gateway.comment.domain.CommentRegisterDto;

import java.util.List;

public interface CommentAdaptor {
    List<CommentDto> getComments(Integer projectId, Integer taskId);

    CommentDto getComment(Integer commentId, Integer projectId, Integer taskId);

    void createComment(CommentRegisterDto commentRegisterDto);

    void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId);

    void deleteComment(Integer commentId);
}
