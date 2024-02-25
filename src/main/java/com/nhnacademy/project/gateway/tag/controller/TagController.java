package com.nhnacademy.project.gateway.tag.controller;

import com.nhnacademy.project.gateway.project.domain.Tag;
import com.nhnacademy.project.gateway.project.service.ProjectService;
import com.nhnacademy.project.gateway.tag.domain.TagRegisterDto;
import com.nhnacademy.project.gateway.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    private final ProjectService projectService;

    @GetMapping
    public String getTags(Model model) {
        model.addAttribute("tags", tagService.getTags());
        return "main/index";
    }

    @PostMapping("/register")
    public String createTag(Tag tag, @RequestParam("projectId") Integer projectId, RedirectAttributes redirectAttributes) {
        tagService.createTag(tag);
        redirectAttributes.addFlashAttribute("project", projectService.getProject(projectId));
        return "redirect:/project/" + projectId;
    }

    @PutMapping("/{tagId}")
    public void updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable("tagId") Integer tagId) {
        tagService.deleteTag(tagId);
    }
}
