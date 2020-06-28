package org.wcci.blog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.wcci.blog.model.Genre;
import org.wcci.blog.service.GenresService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GenresControllerTest {

    private GenresController underTest;
    private GenresService mockGenresService;
    private Model model;

    @BeforeEach
    public void setUp() {
        mockGenresService = mock(GenresService.class);
        underTest = new GenresController(mockGenresService);
        model = Mockito.mock(Model.class);
    }

    @Test
    public void shouldReturnAllGenresTemplateWhenAskedForAllGenres() {
        String templateName = underTest.showAllGenres(model);
        assertThat(templateName).isEqualTo("all-genres-template");
    }

    @Test
    public void showAllGenresAsksServiceForAllGenres() {
        underTest.showAllGenres(model);
        verify(mockGenresService).getAllGenres();
    }

    @Test
    public void showOneGenreAddsRetrievedGenreToModel() {
        Genre testGenre = new Genre("TestGenre");
        when(mockGenresService.getSingleGenre(12345L)).thenReturn(testGenre);
        underTest.showOneGenre(12345L, model);
        verify(model).addAttribute("genre", testGenre);
    }

    @Test
    public void shouldReturnSingleGenreTemplateWhenAskedForSingleGenre() {
        String templateName = underTest.showOneGenre(12345L, model);
        assertThat(templateName).isEqualTo("single-genre-template");
    }

}
