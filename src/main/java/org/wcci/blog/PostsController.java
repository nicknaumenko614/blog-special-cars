package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {
    @RequestMapping({"all-posts"})
    public String showAllPosts(Model model) {
        return "all-posts-template";
    }

    @RequestMapping({"post/{postTitle}"})
    public String showOnePost(Model model) {
        return "single-post-template";

    }
}
