package org.wcci.blog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.model.Genre;
import org.wcci.blog.repository.GenreRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GenresServiceTest {

    private GenreRepository genreRepository;
    private GenresService underTest;

    @BeforeEach
    void setUp() {
        genreRepository = mock(GenreRepository.class);
        underTest = new GenresService(genreRepository);
    }

    @Test
    public void shouldSaveNewGenre() {
        Genre testGenre = new Genre("Car");
        underTest.saveNewGenre(testGenre);
        verify(genreRepository).save(testGenre);
    }

    @Test
    public void shouldGetGenreByName() {
        when(genreRepository.findGenreByGenreName("Car")).thenReturn(new Genre("Car"));
        Genre result = underTest.getGenreByName("Car");
        assertThat(result.getGenreName()).isEqualTo("Car");
    }
}
