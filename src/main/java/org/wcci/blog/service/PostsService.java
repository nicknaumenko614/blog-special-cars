package org.wcci.blog.service;

import org.springframework.stereotype.Service;
import org.wcci.blog.ResourceNotFoundException;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostsService {

    PostRepository postRepo;

    public PostsService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getSinglePost(Long id) {
        Optional<Post> postOptional = postRepo.findById(id);
        Post foundPost;
        if (postOptional.isEmpty()) {
            throw new ResourceNotFoundException("Post not found.");
        } else {
            foundPost = postOptional.get();
        }
        return foundPost;
    }

//    public void save(Post postToSave) {
//        postRepo.save(postToSave);
//        }
}



