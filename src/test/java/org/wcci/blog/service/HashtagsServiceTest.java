package org.wcci.blog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.repository.HashtagRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class HashtagsServiceTest {

    private HashtagRepository hashtagRepository;
    private HashtagsService underTest;

    @BeforeEach
    void setUp() {
        hashtagRepository = mock(HashtagRepository.class);
        underTest = new HashtagsService(hashtagRepository);
    }

    @Test
    public void shouldSaveNewHashtag() {
        Hashtag testHashtag = new Hashtag("TestHashtag");
        underTest.saveNewHashtag(testHashtag);
        verify(hashtagRepository).save(testHashtag);
    }

    @Test
    public void shouldGetHashtagByName() {
        when(hashtagRepository.findHashtagByTagName("TestHashtag")).thenReturn(new Hashtag("TestHashtag"));
        Hashtag result = underTest.getHashtagByName("TestHashtag");
        assertThat(result.getTagName()).isEqualTo("TestHashtag");
    }
}
