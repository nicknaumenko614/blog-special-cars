package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {


    private List<Author> allAuthors = new ArrayList<>();

    public AuthorService() {
        addInitialAuthors();
    }

    private void addInitialAuthors() {
        Author author1 = new Author("Vasya Pupkin", new ArrayList<>());
        Author author2 = new Author("Petya Vaskin", new ArrayList<>());

        allAuthors.add(author1);
        allAuthors.add(author2);
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    public Author getSingleAuthor(String authorToLookup) {
        Author foundAuthor = null;
        for (Author singleAuthor : allAuthors) {
            if (singleAuthor.getAuthorName().equalsIgnoreCase(authorToLookup)) {
                foundAuthor = singleAuthor;
            }

        }
        return foundAuthor;
    }
}
