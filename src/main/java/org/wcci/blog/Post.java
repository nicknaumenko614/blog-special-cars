package org.wcci.blog;

import java.time.LocalDateTime;
import java.util.List;

public class Post {

    private String title;
    private String body;
    private Author author;
    private LocalDateTime publishDate;
    private Genre genre;
    private List<Tag> hashtags;

    public Post(String title, String body, Author author, LocalDateTime publishDate, Genre genre, List<Tag> hashtags) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
        this.hashtags = hashtags;
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

    public List<Tag> getHashtags() {
        return hashtags;
    }
}
