package org.wcci.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(authorName, author.authorName) &&
                Objects.equals(authorsPosts, author.authorsPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, authorsPosts);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorsPosts=" + authorsPosts +
                '}';
    }
}
