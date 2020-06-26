package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.service.HashtagsService;

@Controller
public class HashtagsController {
   private HashtagsService hashtagService;

    public HashtagsController(HashtagsService hashtagService) {
        this.hashtagService = hashtagService;
    }

    @GetMapping("all-hashtags")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagService.getAllHashtags());
        return "all-hashtags-template";
    }

    @GetMapping("hashtag/{id}")
    public String showOneHashtag(@PathVariable Long id, Model model) {
        model.addAttribute("hashtag", hashtagService.getSingleHashtag(id));
        return "single-hashtag-template";

    }
}
