package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HashtagService {

    private List<Hashtag> allHashtags = new ArrayList<>();

    public HashtagService() {
        addInitialHashtags();
    }

    private void addInitialHashtags() {
        Hashtag tag1 = new Hashtag("First Hashtag", new ArrayList<>());
        Hashtag tag2 = new Hashtag("Second Hashtag", new ArrayList<>());

        allHashtags.add(tag1);
        allHashtags.add(tag2);
    }

    public List<Hashtag> getAllHashtags() {
        return allHashtags;
    }

    public Hashtag getSingleHashtag(String hashtagToLookup) {
        Hashtag foundHashtag = null;
        for (Hashtag singleHashtag : allHashtags) {
            if (singleHashtag.getTagName().equalsIgnoreCase(hashtagToLookup)) {
                foundHashtag = singleHashtag;
            }

        }
        return foundHashtag;
    }
}
