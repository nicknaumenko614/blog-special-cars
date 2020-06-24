package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenresService {
    private List<Genre> allGenres = new ArrayList<>();

    public GenresService() {
        addInitialGenres();
    }

    private void addInitialGenres() {
        Post post1 = new Post("First Post Title goes here", "This is the body of first post",
                new Author("Vasya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("New Cars", new ArrayList<>()),
                new ArrayList<>());
        Post post2 = new Post("Second Post Title goes here", "This is the body of second post",
                new Author("Petya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("Used Cars", new ArrayList<>()),
                new ArrayList<>());
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);

        Genre genre1 = new Genre("First Genre", posts);
        Genre genre2 = new Genre("Second Genre", posts);

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
