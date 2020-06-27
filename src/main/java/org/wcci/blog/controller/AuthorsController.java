package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.model.Author;
import org.wcci.blog.service.AuthorsService;

@Controller
public class AuthorsController {
    private AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("all-authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorsService.getAllAuthors());
        return "all-authors-template";
    }

    @GetMapping("author/{id}")
    public String showOneAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorsService.getSingleAuthor(id));
        return "single-author-template";

    }

    @PostMapping("authors/add")
    public String addAuthor(String authorName) {
        if (authorsService.getAuthorByName(authorName) != null) {
            return "redirect:/all-authors";
        }

        Author authorToAdd = new Author(authorName);
        authorsService.saveNewAuthor(authorToAdd);
        return "redirect:/all-authors";
    }

}
