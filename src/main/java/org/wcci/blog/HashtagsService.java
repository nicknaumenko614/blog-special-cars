package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HashtagsService {

    private List<Hashtag> allHashtags = new ArrayList<>();

    public HashtagsService() {
        addInitialHashtags();
    }

    private void addInitialHashtags() {
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

        Hashtag tag1 = new Hashtag("First Hashtag", posts);
        Hashtag tag2 = new Hashtag("Second Hashtag", posts);

        allHashtags.add(tag1);
        allHashtags.add(tag2);
    }

    public List<Hashtag> getAllHashtags() {
        return allHashtags;
    }

    public Hashtag getSingleHashtag(String hashtagToLookup) {
        Hashtag foundHashtag = null;
        for (Hashtag singleHashtag : allHashtags) {
            if (singleHashtag.getTagName().equalsIgnoreCase(hashtagToLookup)) {
                foundHashtag = singleHashtag;
            }

        }
        return foundHashtag;
    }
}
