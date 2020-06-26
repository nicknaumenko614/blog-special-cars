package org.wcci.blog.service;

import org.springframework.stereotype.Service;
import org.wcci.blog.ResourceNotFoundException;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.AuthorRepository;
import org.wcci.blog.repository.HashtagRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HashtagsService {

    HashtagRepository hashtagRepo;

    public HashtagsService(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public Iterable<Hashtag> getAllHashtags() {
        return hashtagRepo.findAll();
    }

    public Hashtag getSingleHashtag(Long id) {
        Optional<Hashtag> hashtagOptional = hashtagRepo.findById(id);
        Hashtag foundHashtag;
        if (hashtagOptional.isEmpty()) {
            throw new ResourceNotFoundException("Hashtag not found.");
        } else {
            foundHashtag = hashtagOptional.get();
        }
        return foundHashtag;
    }


}
