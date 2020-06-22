package org.wcci.blog;

import java.util.List;

public class Tag {
    private String tagName;
    private List<Post> posts;

    public Tag(String tagName, List<Post> posts) {
        this.tagName = tagName;
        this.posts = posts;
    }

    public String getTagName() {
        return tagName;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
