package com.nhnacademy.project.gateway.tag.config.adaptor;

import com.nhnacademy.project.gateway.project.domain.Tag;
import com.nhnacademy.project.gateway.tag.domain.TagRegisterDto;

import java.util.List;

public interface TagAdaptor {
    List<Tag> getAllTags();
    Tag getTag(Integer tagId);
    void createTag(TagRegisterDto registerDto);
    void deleteTag(Integer tagId);

    void updateTag(Tag tag);
}
