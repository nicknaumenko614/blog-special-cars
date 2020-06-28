package org.wcci.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.model.Hashtag;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class HashtagRepositoryTest {


    @Autowired
    private HashtagRepository hashtagRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findHashtagByTagNameShouldReturnCorrectTag() {
        Hashtag testHashtag1 = new Hashtag("TestHashtag1");
        Hashtag testHashtag2 = new Hashtag("TestHashtag2");
        Hashtag testHashtag3 = new Hashtag("TestHashtag3");

        hashtagRepository.save(testHashtag1);
        hashtagRepository.save(testHashtag2);
        hashtagRepository.save(testHashtag3);

        entityManager.flush();
        entityManager.clear();

        Hashtag retrievedHashtag = hashtagRepository.findHashtagByTagName("TestHashtag3");
        assertThat(retrievedHashtag.getTagName()).isEqualTo("TestHashtag3");

    }
}

