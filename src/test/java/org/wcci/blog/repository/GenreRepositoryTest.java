package org.wcci.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GenreRepositoryTest {


    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findGenreByGenreNameShouldReturnCorrectGenre() {
        Genre testGenre1 = new Genre ("TestGenre1");
        Genre testGenre2 = new Genre ("TestGenre2");
        Genre testGenre3 = new Genre ("TestGenre3");

        genreRepository.save(testGenre1);
        genreRepository.save(testGenre2);
        genreRepository.save(testGenre3);

        entityManager.flush();
        entityManager.clear();

//        Genre retrievedGenre = genreRepository.findGenreByGenreName(testGenre2.getGenreName());
//        assertThat(retrievedGenre).isEqualTo(testGenre2);

        Genre retrievedGenre = genreRepository.findGenreByGenreName ("TestGenre2");
        assertThat(retrievedGenre.getGenreName()).isEqualTo("TestGenre2");

    }
}
