package org.wcci.blog;

import java.util.List;

public class Author {
    private String authorName;
    private List<Post> authorsPosts;

    public Author(String authorName, List<Post> authorsPosts) {
        this.authorName = authorName;
        this.authorsPosts = authorsPosts;
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Post> getAuthorsPosts() {
        return authorsPosts;
    }
}
