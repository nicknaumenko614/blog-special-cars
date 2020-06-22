package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    @RequestMapping({"all-authors"})
    public String showAllAuthors(Model model) {
        return "all-authors-template";
    }
    @RequestMapping({"author/{authorName}"})
    public String showOneAuthor(Model model) {
        return "single-author-template";

    }

}
