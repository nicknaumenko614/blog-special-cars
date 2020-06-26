package org.wcci.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
