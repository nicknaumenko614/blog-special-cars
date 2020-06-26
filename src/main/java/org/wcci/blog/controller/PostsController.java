package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.service.PostsService;

@Controller
public class PostsController {
    private PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("all-posts")
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postsService.getAllPosts());
        return "all-posts-template";
    }

    @GetMapping("post/{id}")
    public String showOnePost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postsService.getSinglePost(id));
        return "single-post-template";

    }
}
