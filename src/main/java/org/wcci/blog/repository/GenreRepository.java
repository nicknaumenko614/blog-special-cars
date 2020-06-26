package org.wcci.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
