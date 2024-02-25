package com.nhnacademy.project.gateway.tag.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Integer tagId;
    private String tagName;
    private Integer projectId;
}
