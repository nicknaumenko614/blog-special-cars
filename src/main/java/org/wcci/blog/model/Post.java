package org.wcci.blog.model;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(length = 2000)
    private String body;
    @ManyToOne
    private Author author;
    private LocalDateTime publishDate;
    private String imageURL;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    private List<Hashtag> hashtags;

    protected Post() {
    }

    public Post(String title, String body, Author author, LocalDateTime publishDate, String imageURL, Genre genre, List<Hashtag> hashtags) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
        this.hashtags =hashtags;
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public String getImageURL() {
        return imageURL;
    }
}
