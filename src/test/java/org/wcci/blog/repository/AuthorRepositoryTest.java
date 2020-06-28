package org.wcci.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAuthorByAuthorNameShouldReturnCorrectAuthor() {
        Author testAuthor1 = new Author("testy1");
        Author testAuthor2 = new Author("testy2");
        Author testAuthor3 = new Author("testy3");
        authorRepository.save(testAuthor1);
        authorRepository.save(testAuthor2);
        authorRepository.save(testAuthor3);

        entityManager.flush();
        entityManager.clear();

//        Author retrievedAuthor = authorRepository.findAuthorByAuthorName(testAuthor1.getAuthorName());
//        assertThat(retrievedAuthor).isEqualTo(testAuthor1);

        Author retrievedAuthor = authorRepository.findAuthorByAuthorName("testy1");
        assertThat(retrievedAuthor.getAuthorName()).isEqualTo("testy1");
    }

}
