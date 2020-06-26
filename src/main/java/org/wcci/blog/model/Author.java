package org.wcci.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String authorName;
    @OneToMany(mappedBy = "author")
    private List<Post> authorsPosts;

    protected Author(){}

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Post> getAuthorsPosts() {
        return authorsPosts;
    }
}
