package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.service.HashtagsService;

@Controller
public class HashtagsController {
    private HashtagsService hashtagsService;

    public HashtagsController(HashtagsService hashtagsService) {
        this.hashtagsService = hashtagsService;
    }

    @GetMapping("all-hashtags")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagsService.getAllHashtags());
        return "all-hashtags-template";
    }

    @GetMapping("hashtag/{id}")
    public String showOneHashtag(@PathVariable Long id, Model model) {
        model.addAttribute("hashtag", hashtagsService.getSingleHashtag(id));
        return "single-hashtag-template";

    }

    @PostMapping("hashtag/add")
    public String addHashtag(String hashtagName) {
        if (hashtagsService.getHashtagByName(hashtagName) != null) {
            return "redirect:/all-hashtags";
        }

        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagsService.saveNewHashtag(hashtagToAdd);
        return "redirect:/all-hashtags";
    }
}
