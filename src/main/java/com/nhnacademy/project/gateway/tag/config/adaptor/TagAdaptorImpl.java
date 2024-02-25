package com.nhnacademy.project.gateway.tag.config.adaptor;

import com.nhnacademy.project.gateway.project.domain.Tag;
import com.nhnacademy.project.gateway.tag.config.TagAdaptorProperties;
import com.nhnacademy.project.gateway.tag.domain.TagRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class TagAdaptorImpl implements TagAdaptor {
    private final RestTemplate restTemplate;
    private final TagAdaptorProperties properties;
    private final String address;

    @Autowired
    public TagAdaptorImpl(RestTemplate restTemplate, TagAdaptorProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.address = properties.getAddress();
    }

    @Override
    public List<Tag> getAllTags() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Tag>> exchange = restTemplate.exchange(
                address,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        return exchange.getBody();
    }

    @Override
    public Tag getTag(Integer tagId) {
        ResponseEntity<Tag> exchange = restTemplate.getForEntity(
                address + "/{id}",
                Tag.class,
                tagId);
        return exchange.getBody();
    }

    @Override
    public void createTag(TagRegisterDto tagRegisterDto) {
        log.info("{}", address);
        restTemplate.postForEntity(
                address + "/register",
                tagRegisterDto,
                TagRegisterDto.class);
    }

    @Override
    public void deleteTag(Integer tagId) {
        restTemplate.delete(
                address + "/{tagId}",
                tagId);
    }

    @Override
    public void updateTag(Tag tag) {
        restTemplate.put(
                address + "/{tagId}",
                tag,
                tag.getTagId());
    }
}
