package org.wcci.blog.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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
        Post retrievedPost = postRepository.findPostByTitle("Tesla Model S");
        assertThat(retrievedPost.getTitle()).isEqualTo("Tesla Model S");
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
        Post post1 = new Post("Honda CRX Si",
                "The Honda CRX Si is a brilliant little car- endowed with not much power and a scant curb weight to match. " +
                        "In 1988, the second-generation CRX Si was introduced in North America. These later cars are the stuff of legend. " +
                        "They were cheap, light, precise, and about as mechanically complex as a screwdriver. " +
                        "They also came at a small sticker price, further adding to their desirability.",
                author1,
                LocalDateTime.now(),
                "../../images/CRX1.jpg",
                genre1,
                hashtagList1);

        List<Hashtag> hashtagList2 = new ArrayList<>();
        hashtagList2.add(hashtag2);
        hashtagList2.add(hashtag3);
        Post post2 = new Post("Tesla Model S",
                "Tesla effectively created the luxury electric segment with the introduction of the first Model S back in 2012. " +
                        "Eight years later, larger, more established automakers are still trying to catch up. " +
                        "It's a car that changed the game and continues to serve as an industry benchmark. " +
                        "Today, with dual-motor AWD, autopilot, and ability to increase range past the 400-mile mark, the car still outperforms most of the other EV offerings on the market.",
                author2,
                LocalDateTime.now(),
                "../../images/teslaS.jpg",
                genre2,
                hashtagList2);

        postRepository.save(post1);
        postRepository.save(post2);
    }
}

