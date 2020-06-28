package org.wcci.blog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.AuthorRepository;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostsServiceTest {

    private PostRepository postRepository;
    private PostsService underTest;
    private Post testPost;

    @BeforeEach
    void setUp() {
        postRepository = mock(PostRepository.class);
        underTest = new PostsService(postRepository);
        testPost = generateTestPost();
    }

    private Post generateTestPost() {
        Genre genre1 = new Genre("TestGenre");
        Author author1 = new Author("TestAuthor");
        Hashtag hashtag1 = new Hashtag("TestHashtag");

        List<Hashtag> hashtagList1 = new ArrayList<>();
        hashtagList1.add(hashtag1);

        Post post1 = new Post("TestPost",
                "This is the body of first post",
                author1,
                LocalDateTime.now(),
                genre1,
                hashtagList1);
        return post1;
    }

    @Test
    public void shouldSaveNewPost() {

        underTest.saveNewPost(testPost);
        verify(postRepository).save(testPost);
    }

    @Test
    public void shouldGetPostByTitle() {
        when(postRepository.findPostByTitle("TestPost")).thenReturn(testPost);
        Post result = underTest.getPostByTitle("TestPost");
        assertThat(result.getTitle()).isEqualTo("TestPost");
    }
}
