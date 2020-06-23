package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {
    private PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping("all-posts")
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postsService.getAllPosts());
        return "all-posts-template";
    }

    @RequestMapping("post/{postTitle}")
    public String showOnePost(@PathVariable String postTitle, Model model) {
        model.addAttribute("post", postsService.getSinglePost(postTitle));
        return "single-post-template";

    }
}
