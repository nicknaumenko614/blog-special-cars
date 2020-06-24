package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagsController {
   private HashtagsService hashtagService;

    public HashtagsController(HashtagsService hashtagService) {
        this.hashtagService = hashtagService;
    }

    @RequestMapping("all-hashtags")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagService.getAllHashtags());
        return "all-hashtags-template";
    }

    @RequestMapping("hashtag/{hashtagName}")
    public String showOneHashtag(@PathVariable String hashtagName, Model model) {
        model.addAttribute("hashtag", hashtagService.getSingleHashtag(hashtagName));
        return "single-hashtag-template";

    }
}
