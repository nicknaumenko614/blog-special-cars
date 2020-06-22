package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenresController {
    @RequestMapping({"all-genres"})
    public String showAllGenres(Model model) {
        return "all-genres-template";
    }

    @RequestMapping({"genre/{genreName}"})
    public String showOneGenre(Model model) {
        return "single-genre-template";

    }
}
