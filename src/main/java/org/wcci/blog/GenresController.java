package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenresController {
    private GenreService genreService;

    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping("all-genres")
    public String showAllGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        return "all-genres-template";
    }

    @RequestMapping("genre/{genreName}")
    public String showOneGenre(@PathVariable String genreName, Model model) {
        model.addAttribute("genre", genreService.getSingleGenre(genreName));
        return "single-genre-template";

    }
}
