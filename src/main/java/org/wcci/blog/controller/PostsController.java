package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.service.AuthorsService;
import org.wcci.blog.service.GenresService;
import org.wcci.blog.service.HashtagsService;
import org.wcci.blog.service.PostsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class PostsController {
    private PostsService postsService;
    private GenresService genresService;
    private AuthorsService authorsService;
    private HashtagsService hashtagsService;

    public PostsController(PostsService postsService, GenresService genresService, AuthorsService authorsService, HashtagsService hashtagsService) {
        this.postsService = postsService;
        this.genresService = genresService;
        this.authorsService = authorsService;
        this.hashtagsService = hashtagsService;
    }


    @GetMapping("all-posts")
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postsService.getAllPosts());
        model.addAttribute("genres", genresService.getAllGenres());
        model.addAttribute("authors", authorsService.getAllAuthors());
        model.addAttribute("hashtags", hashtagsService.getAllHashtags());
        return "all-posts-template";
    }

    @GetMapping("post/{id}")
    public String showOnePost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postsService.getSinglePost(id));
        return "single-post-template";

    }

    @PostMapping("posts/add")
    public String addPost(String title, String body, Long authorId, Long genreId, String imageURL, Long... hashtagIds) {
        if (postsService.getPostByTitle(title) != null) {
            return "redirect:/all-posts";
        }

        Author author = authorsService.getSingleAuthor(authorId);
        Genre genre = genresService.getSingleGenre(genreId);

        List<Hashtag> hashtags = new ArrayList<>();
        List<Long> hashtagsIdsList = new ArrayList<>(Arrays.asList(hashtagIds));
        for (Long singleHashtagId : hashtagsIdsList) {
            Hashtag hashtag = hashtagsService.getSingleHashtag(singleHashtagId);
            hashtags.add(hashtag);
        }


        Post postToAdd = new Post(title, body, author, LocalDateTime.now(), imageURL, genre, hashtags);
        postsService.saveNewPost(postToAdd);
        return "redirect:/all-posts";
    }

    @PostMapping("posts/delete")
    public String deletePost(long postId) {
        Post postToDelete = postsService.getSinglePost(postId);
        postsService.deletePost(postId);
        return "redirect:/all-posts";
    }

}
