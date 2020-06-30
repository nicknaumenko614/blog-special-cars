package org.wcci.blog.service;

import org.springframework.stereotype.Service;
import org.wcci.blog.ResourceNotFoundException;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.HashtagRepository;
import org.wcci.blog.repository.PostRepository;
import java.util.*;

@Service
public class PostsService {

    PostRepository postRepo;
    HashtagRepository hashtagRepo;


    public PostsService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getPostByTitle(String postTitle) {
        return postRepo.findPostByTitle(postTitle);
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

    public void saveNewPost(Post postToSave) {
        postRepo.save(postToSave);
        }

    public void deletePost(long postId) {
        postRepo.deleteById(postId);
    }


}



