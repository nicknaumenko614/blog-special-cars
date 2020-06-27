package org.wcci.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.model.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Hashtag findHashtagByTagName (String tagName);
}
