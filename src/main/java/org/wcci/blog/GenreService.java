package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private List<Genre> allGenres = new ArrayList<>();

    public GenreService() {
        addInitialGenres();
    }

    private void addInitialGenres() {
        Genre genre1 = new Genre("First Genre", new ArrayList<>());
        Genre genre2 = new Genre("Second Genre", new ArrayList<>());

        allGenres.add(genre1);
        allGenres.add(genre2);
    }

    public List<Genre> getAllGenres() {
        return allGenres;
    }

    public Genre getSingleGenre(String genreToLookup) {
        Genre foundGenre = null;
        for (Genre singleGenre : allGenres) {
            if (singleGenre.getGenreName().equalsIgnoreCase(genreToLookup)) {
                foundGenre = singleGenre;
            }

        }
        return foundGenre;
    }


}
