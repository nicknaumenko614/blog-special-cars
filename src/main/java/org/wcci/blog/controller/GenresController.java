package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.model.Genre;
import org.wcci.blog.service.GenresService;

@Controller
public class GenresController {
    private GenresService genresService;

    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping("all-genres")
    public String showAllGenres(Model model) {
        model.addAttribute("genres", genresService.getAllGenres());
        return "all-genres-template";
    }

    @GetMapping("genre/{id}")
    public String showOneGenre(@PathVariable Long id, Model model) {
        model.addAttribute("genre", genresService.getSingleGenre(id));
        return "single-genre-template";

    }

    @PostMapping("genres/add")
    public String addGenre(String genreName) {
        if (genresService.getGenreByName(genreName) != null) {
            return "redirect:/all-genres";
        }

        Genre genreToAdd = new Genre(genreName);
        genresService.saveNewGenre(genreToAdd);
        return "redirect:/all-genres";

    }
}
