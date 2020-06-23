package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    private AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("all-authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "all-authors-template";
    }
    @RequestMapping("author/{authorName}")
    public String showOneAuthor(@PathVariable String authorName, Model model) {
        model.addAttribute( "author", authorService.getSingleAuthor(authorName));
        return "single-author-template";

    }

}
