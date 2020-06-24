package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsService {


    private List<Author> allAuthors = new ArrayList<>();

    public AuthorsService() {
        addInitialAuthors();
    }

    private void addInitialAuthors() {
        Hashtag tag1 = new Hashtag("First Hashtag", new ArrayList<>());
        Hashtag tag2 = new Hashtag("Second Hashtag", new ArrayList<>());
        List<Hashtag> hashtags = new ArrayList<>();

        hashtags.add(tag1);
        hashtags.add(tag2);

        Post post1 = new Post("First Post Title goes here", "This is the body of first post",
                new Author("Vasya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("New Cars", new ArrayList<>()),
                hashtags);
        Post post2 = new Post("Second Post Title goes here", "This is the body of second post",
                new Author("Petya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("Used Cars", new ArrayList<>()),
                new ArrayList<>());
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);

        Author author1 = new Author("Vasya Pupkin", posts);
        Author author2 = new Author("Petya Vaskin", posts);

        allAuthors.add(author1);
        allAuthors.add(author2);
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    public Author getSingleAuthor(String authorToLookup) {
        Author foundAuthor = null;
        for (Author singleAuthor : allAuthors) {
            if (singleAuthor.getAuthorName().equalsIgnoreCase(authorToLookup)) {
                foundAuthor = singleAuthor;
            }

        }
        return foundAuthor;
    }
}
