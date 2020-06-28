package org.wcci.blog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.wcci.blog.model.Author;
import org.wcci.blog.service.AuthorsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
public class AuthorsControllerTest {

    private AuthorsController underTest;
    private AuthorsService mockAuthorsService;
    private Model model;

    @BeforeEach
    public void setUp() {
        mockAuthorsService = mock(AuthorsService.class);
        underTest = new AuthorsController(mockAuthorsService);
        model = Mockito.mock(Model.class);
    }

    @Test
    public void shouldReturnAllAuthorsTemplateWhenAskedForAllAuthors() {
        String templateName = underTest.showAllAuthors(model);
        assertThat(templateName).isEqualTo("all-authors-template");
    }

    @Test
    public void showAllAuthorAsksServiceForAllAuthors() {
        underTest.showAllAuthors(model);
        verify(mockAuthorsService).getAllAuthors();
    }

    @Test
    public void showOneAuthorAddsRetrievedAuthorToModel() {
        Author testAuthor = new Author("TestAuthor");
        when(mockAuthorsService.getSingleAuthor(12345L)).thenReturn(testAuthor);
        underTest.showOneAuthor(12345L, model);
        verify(model).addAttribute("author", testAuthor);
    }

    @Test
    public void shouldReturnSingleAuthorTemplateWhenAskedForSingleAuthor() {
        String templateName = underTest.showOneAuthor(12345L, model);
        assertThat(templateName).isEqualTo("single-author-template");
    }

}
