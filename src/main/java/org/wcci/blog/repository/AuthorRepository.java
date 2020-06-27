package org.wcci.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findAuthorByAuthorName(String authorName);
}
