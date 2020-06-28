package org.wcci.blog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.service.HashtagsService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class HashtagsControllerTest {

    private HashtagsController underTest;
    private HashtagsService mockHashtagsService;
    private Model model;

    @BeforeEach
    public void setUp() {
        mockHashtagsService = mock(HashtagsService.class);
        underTest = new HashtagsController(mockHashtagsService);
        model = Mockito.mock(Model.class);
    }

    @Test
    public void shouldReturnAllHashtagsTemplateWhenAskedForAllHashtags() {
        String templateName = underTest.showAllHashtags(model);
        assertThat(templateName).isEqualTo("all-hashtags-template");
    }

    @Test
    public void showAllHashtagsAsksServiceForAllHashtags() {
        underTest.showAllHashtags(model);
        verify(mockHashtagsService).getAllHashtags();
    }

    @Test
    public void showOneHashtagAddsRetrievedHashtagToModel() {
        Hashtag testHashtag = new Hashtag("TestHashtag");
        when(mockHashtagsService.getSingleHashtag(12345L)).thenReturn(testHashtag);
        underTest.showOneHashtag(12345L, model);
        verify(model).addAttribute("hashtag", testHashtag);
    }

    @Test
    public void shouldReturnSingleHashtagTemplateWhenAskedForSingleHashtag() {
        String templateName = underTest.showOneHashtag(12345L, model);
        assertThat(templateName).isEqualTo("single-hashtag-template");
    }

}
