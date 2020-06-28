package org.wcci.blog.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.Populator;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private HashtagRepository hashtagRepo;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    public void setUp() throws Exception {
        initTestPosts();
    }

    @Test
    public void findPostByTitleShouldReturnCorrectPost() {
        Post retrievedPost = postRepository.findPostByTitle("Second Post Title goes here");
        assertThat(retrievedPost.getTitle()).isEqualTo("Second Post Title goes here");
        assertThat(retrievedPost.getAuthor().getAuthorName()).isEqualTo("Vasya P.");

    }

    public void initTestPosts() {
        Genre genre1 = new Genre("New Special Cars (2010 to Current)");
        Genre genre2 = new Genre("Modern Special Cars (1980's to 2000's)");
        Genre genre3 = new Genre("Classic Special Cars(1930's - 1970's)");
        genreRepo.save(genre1);
        genreRepo.save(genre2);
        genreRepo.save(genre3);

        Author author1 = new Author("Nick N.");
        Author author2 = new Author("Vasya P.");
        authorRepo.save(author1);
        authorRepo.save(author2);

        Hashtag hashtag1 = new Hashtag("Fast Car");
        Hashtag hashtag2 = new Hashtag("Rare car");
        Hashtag hashtag3 = new Hashtag("Electric power!");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);

        List<Hashtag> hashtagList1 = new ArrayList<>();
        hashtagList1.add(hashtag1);
        hashtagList1.add(hashtag3);
        Post post1 = new Post("First Post Title goes here",
                "This is the body of first post",
                author1,
                LocalDateTime.now(),
                genre1,
                hashtagList1);

        List<Hashtag> hashtagList2 = new ArrayList<>();
        hashtagList2.add(hashtag2);
        hashtagList2.add(hashtag3);
        Post post2 = new Post("Second Post Title goes here",
                "This is the body of second post",
                author2,
                LocalDateTime.now(),
                genre2,
                hashtagList2);

        postRepository.save(post1);
        postRepository.save(post2);
    }
}

