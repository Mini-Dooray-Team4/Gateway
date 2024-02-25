package com.nhnacademy.project.gateway.comment.adaptor;

import com.nhnacademy.project.gateway.comment.config.CommentAdaptorProperties;
import com.nhnacademy.project.gateway.comment.domain.Comment;
import com.nhnacademy.project.gateway.comment.domain.CommentDto;
import com.nhnacademy.project.gateway.comment.domain.CommentRegisterDto;
import com.nhnacademy.project.gateway.project.config.ProjectAdaptorProperties;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CommentAdaptorImpl implements CommentAdaptor{

    private final RestTemplate restTemplate;
    private final CommentAdaptorProperties commentAdaptorProperties;
    private final String address;

    public CommentAdaptorImpl(RestTemplate restTemplate, CommentAdaptorProperties commentAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.commentAdaptorProperties = commentAdaptorProperties;
        this.address = commentAdaptorProperties.getAddress();
    }


    @Override
    public List<CommentDto> getComments(Integer projectId, Integer taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<CommentDto>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {},
                projectId, taskId
        );

        if(exchange.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException();
        }

        return exchange.getBody();
    }

    @Override
    public CommentDto getComment(Integer commentId, Integer projectId, Integer taskId) {
        ResponseEntity<CommentDto> exchange = restTemplate.getForEntity(
                address + "/{commentId}",
                CommentDto.class,
                projectId, taskId, commentId
        );
        return exchange.getBody();
    }

    @Override
    public void createComment(CommentRegisterDto commentRegisterDto) {
        restTemplate.postForEntity(
                address,
                commentRegisterDto,
                Void.class,
                commentRegisterDto.getProjectId(),
                commentRegisterDto.getTaskId()
        );

    }

    @Override
    public void updateComment(CommentRegisterDto commentRegisterDto, Integer commentId) {
        restTemplate.put(
                address + "{commentId}",
                CommentRegisterDto.class,
                Void.class,
                commentId
        );
    }

    @Override
    public void deleteComment(Integer commentId) {
        restTemplate.delete(
                address + "/{commentId}",
                commentId
        );

    }
}
