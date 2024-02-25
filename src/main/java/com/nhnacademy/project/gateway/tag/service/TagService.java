package com.nhnacademy.project.gateway.tag.service;

import com.nhnacademy.project.gateway.project.domain.Tag;
import com.nhnacademy.project.gateway.tag.config.adaptor.TagAdaptor;
import com.nhnacademy.project.gateway.tag.domain.TagRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagAdaptor tagAdaptor;

    public List<Tag> getTags() {
        return tagAdaptor.getAllTags();
    }

    public Tag getTag(Integer tagId) {
        return tagAdaptor.getTag(tagId);
    }

    public void createTag(TagRegisterDto registerDto) {
        tagAdaptor.createTag(registerDto);
    }

    public void updateTag(Tag tag) {
        tagAdaptor.updateTag(tag);
    }

    public void deleteTag(Integer tagId) {
        tagAdaptor.deleteTag(tagId);
    }
}
