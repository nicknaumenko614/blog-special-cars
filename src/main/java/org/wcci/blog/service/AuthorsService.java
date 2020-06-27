package org.wcci.blog.service;

import org.springframework.stereotype.Service;
import org.wcci.blog.ResourceNotFoundException;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.AuthorRepository;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {


    AuthorRepository authorRepo;

    public AuthorsService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author getAuthorByName(String authorName) {
        return authorRepo.findAuthorByAuthorName(authorName);
    }


    public Iterable<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getSingleAuthor(Long id) {
        Optional<Author> authorOptional = authorRepo.findById(id);
        Author foundAuthor;
        if (authorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Author not found.");
        } else {
            foundAuthor = authorOptional.get();
        }
        return foundAuthor;
    }

    public void saveNewAuthor(Author authorToSave) {
        authorRepo.save(authorToSave);
    }
}