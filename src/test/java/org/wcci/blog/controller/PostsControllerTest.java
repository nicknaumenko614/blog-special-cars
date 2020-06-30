package org.wcci.blog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class PostsControllerTest {

    private PostsController underTest;
    private PostsService mockPostsService;
    private GenresService mockGenresService;
    private AuthorsService mockAuthorsService;
    private HashtagsService mockHashtagsService;
    private Model model;
    private Post testPost;

    @BeforeEach
    public void setUp() {
        mockPostsService = mock(PostsService.class);
        mockAuthorsService = mock(AuthorsService.class);
        mockGenresService = mock(GenresService.class);
        mockHashtagsService = mock(HashtagsService.class);
        underTest = new PostsController(mockPostsService, mockGenresService, mockAuthorsService, mockHashtagsService);
        model = Mockito.mock(Model.class);
        testPost = generateTestPost();
    }

    @Test
    public void shouldReturnAllPostsTemplateWhenAskedForAllPosts() {
        String templateName = underTest.showAllPosts(model);
        assertThat(templateName).isEqualTo("all-posts-template");
    }

    @Test
    public void showAllPostsAsksServiceForAllPosts() {
        underTest.showAllPosts(model);
        verify(mockPostsService).getAllPosts();
    }

    @Test
    public void showOnePostAddsRetrievedPostToModel() {
        when(mockPostsService.getSinglePost(12345L)).thenReturn(testPost);
        underTest.showOnePost(12345L, model);
        verify(model).addAttribute("post", testPost);
    }

    @Test
    public void shouldReturnSinglePostTemplateWhenAskedForSinglePost() {
        String templateName = underTest.showOnePost(12345L, model);
        assertThat(templateName).isEqualTo("single-post-template");
    }

    private Post generateTestPost() {
        Genre genre1 = new Genre("TestGenre");
        Author author1 = new Author("TestAuthor");
        Hashtag hashtag1 = new Hashtag("TestHashtag");

        List<Hashtag> hashtagList1 = new ArrayList<>();
        hashtagList1.add(hashtag1);

        Post post1 = new Post("Honda CRX Si",
                "The Honda CRX Si is a brilliant little car- endowed with not much power and a scant curb weight to match. \" +\n" +
                        "                        \"In 1988, the second-generation CRX Si was introduced in North America. These later cars are the stuff of legend. \" +\n" +
                        "                        \"They were cheap, light, precise, and about as mechanically complex as a screwdriver. \" +\n" +
                        "                        \"They also came at a small sticker price, further adding to their desirability.",
                author1,
                LocalDateTime.now(),
                "../../images/CRX1.jpg",
                genre1,
                hashtagList1);
        return post1;
    }
}
