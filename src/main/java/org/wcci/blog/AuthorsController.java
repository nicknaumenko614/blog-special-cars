package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    private AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @RequestMapping("all-authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorsService.getAllAuthors());
        return "all-authors-template";
    }
    @RequestMapping("author/{authorName}")
    public String showOneAuthor(@PathVariable String authorName, Model model) {
        model.addAttribute( "author", authorsService.getSingleAuthor(authorName));
        return "single-author-template";

    }

}
