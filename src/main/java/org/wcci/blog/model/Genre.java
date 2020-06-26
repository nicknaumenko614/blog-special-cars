package org.wcci.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private long id;
    private String genreName;
    @OneToMany(mappedBy = "genre")
    private List<Post> posts;

    protected Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;

    }

    public String getGenreName() {
        return genreName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Long getId() {
        return id;
    }
}
