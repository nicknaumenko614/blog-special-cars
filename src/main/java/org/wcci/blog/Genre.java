package org.wcci.blog;

import java.util.List;

public class Genre {
    private String genreName;
    private List<Post> posts;

    public Genre(String genreName, List<Post> posts) {
        this.genreName = genreName;
        this.posts = posts;
    }

    public String getGenreName() {
        return genreName;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
