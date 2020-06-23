package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostsService {

    private List<Post> allPosts = new ArrayList<>();

    public PostsService() {
        addInitialPosts();
    }

    private void addInitialPosts() {
        Tag tag1 = new Tag("First Hashtag", new ArrayList<>());
        Tag tag2 = new Tag("Second Hashtag", new ArrayList<>());
        List<Tag> hashtags = new ArrayList<>();

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

        allPosts.add(post1);
        allPosts.add(post2);
    }

    public List<Post> getAllPosts() {
        return allPosts;
    }

    public Post getSinglePost(String postTitleToLookup) {
        Post foundPost = null;
        for (Post singlePost : allPosts) {
            if (singlePost.getTitle().equalsIgnoreCase(postTitleToLookup)) {
                foundPost = singlePost;
            }

        }
        return foundPost;
    }
}