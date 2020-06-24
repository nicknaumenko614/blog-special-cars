package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenresController {
    private GenresService genresService;

    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @RequestMapping("all-genres")
    public String showAllGenres(Model model) {
        model.addAttribute("genres", genresService.getAllGenres());
        return "all-genres-template";
    }

    @RequestMapping("genre/{genreName}")
    public String showOneGenre(@PathVariable String genreName, Model model) {
        model.addAttribute("genre", genresService.getSingleGenre(genreName));
        return "single-genre-template";

    }
}
