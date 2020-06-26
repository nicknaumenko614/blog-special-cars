package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.AuthorRepository;
import org.wcci.blog.repository.GenreRepository;
import org.wcci.blog.repository.HashtagRepository;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    GenreRepository genreRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
        Genre genre1 = new Genre("New Special Cars (2010 to Current)");
        Genre genre2 = new Genre("Modern Special Cars (1980's to 2000's)");
        Genre genre3 = new Genre("Classic Special Cars(1930's - 1970's)");
        genreRepo.save(genre1);
        genreRepo.save(genre2);
        genreRepo.save(genre3);

        Author author1 = new Author("Nick N.");
        Author author2 = new Author("Vasya P.");
        authorRepo.save(author1);
        authorRepo.save(author2);

        Hashtag hashtag1 = new Hashtag("Fast Car");
        Hashtag hashtag2 = new Hashtag("Rare car");
        Hashtag hashtag3 = new Hashtag("Electric power!");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);

        Post post1 = new Post("First Post Title goes here",
                "This is the body of first post",
                author1,
                LocalDateTime.now(),
                genre1,
                hashtag1, hashtag3);
        Post post2 = new Post("Second Post Title goes here",
                "This is the body of second post",
                author2,
                LocalDateTime.now(),
                genre2,
                hashtag2, hashtag3);
        List<Post> posts = new ArrayList<>();
        postRepo.save(post1);
        postRepo.save(post2);


    }
}
