package org.wcci.blog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.model.Author;
import org.wcci.blog.repository.AuthorRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorsServiceTest {

    private AuthorRepository authorRepository;
    private AuthorsService underTest;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        underTest = new AuthorsService(authorRepository);
    }

    @Test
    public void shouldSaveNewAuthor() {
        Author testAuthor = new Author("John");
        underTest.saveNewAuthor(testAuthor);
        verify(authorRepository).save(testAuthor);
    }

    @Test
    public void shouldGetAuthorByName() {
        when(authorRepository.findAuthorByAuthorName("John")).thenReturn(new Author("John"));
        Author result = underTest.getAuthorByName("John");
        assertThat(result.getAuthorName()).isEqualTo("John");
    }
}



