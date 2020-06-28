package org.wcci.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id &&
                Objects.equals(genreName, genre.genreName) &&
                Objects.equals(posts, genre.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreName, posts);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
