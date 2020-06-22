package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagsController {
    @RequestMapping({"all-hashtags"})
    public String showAllHashtags(Model model) {
        return "all-hashtags-template";
    }

    @RequestMapping({"hashtag/{hashtagName}"})
    public String showOnePost(Model model) {
        return "single-hashtag-template";

    }
}
