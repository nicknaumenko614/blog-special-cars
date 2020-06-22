package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostsService {

    private List<Post> allPosts = new ArrayList<>();

    public void addInitialPosts() {

        Post post1 = new Post("First Post Title goes here", "This is the body of first post",
                new Author("Vasya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("New Cars", new ArrayList<>()), new Tag("tag1", new ArrayList<>()));
        Post post2 = new Post("Second Post Title goes here", "This is the body of second post",
                new Author("Petya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("Used Cars", new ArrayList<>()),
                new Tag("tag2", new ArrayList<>()));

        allPosts.add(post1);
        allPosts.add(post2);
    }

    public List<Post> getAllPosts() {
        addInitialPosts();
        return allPosts;
    }
}