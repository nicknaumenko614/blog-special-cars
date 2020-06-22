package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {

    private List<Post> allPosts = new ArrayList<>();

    protected List<Post> getAllPosts() {
        Post post1 = new Post("First Post Title", "This is the body of first post",
                new Author("Vasya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("New Cars", new ArrayList<>()),
                new ArrayList<>());
        Post post2 = new Post("Second Post Title", "This is the body of second post",
                new Author("Petya", new ArrayList<>()),
                LocalDateTime.now(),
                new Genre("Used Cars", new ArrayList<>()),
                new ArrayList<>());
        allPosts.add(post1);
        allPosts.add(post2);

        return allPosts;
    }
}
