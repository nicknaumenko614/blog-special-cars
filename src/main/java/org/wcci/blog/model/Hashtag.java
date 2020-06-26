package org.wcci.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String tagName;
    @ManyToMany(mappedBy = "hashtags")
    private List<Post> posts;

    protected Hashtag(){}

    public Hashtag(String tagName) {
        if (tagName.charAt(0) != '#') {
            this.tagName = tagName;
        } else {
            this.tagName = tagName.substring(1, tagName.length());
        }
    }

    public long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
