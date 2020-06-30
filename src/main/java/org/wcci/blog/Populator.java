package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Hashtag;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.AuthorRepository;
import org.wcci.blog.repository.GenreRepository;
import org.wcci.blog.repository.HashtagRepository;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    GenreRepository genreRepo;
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
        Genre genre1 = new Genre("New Special Cars (2010 to Current)");
        Genre genre2 = new Genre("Modern Special Cars (1980's to 2000's)");
        Genre genre3 = new Genre("Classic Special Cars(1930's - 1970's)");
        genreRepo.save(genre1);
        genreRepo.save(genre2);
        genreRepo.save(genre3);

        Author author1 = new Author("Nick N.");
        Author author2 = new Author("John D.");
        authorRepo.save(author1);
        authorRepo.save(author2);

        Hashtag hashtag1 = new Hashtag("Fast");
        Hashtag hashtag2 = new Hashtag("Rare");
        Hashtag hashtag3 = new Hashtag("Electric power!");
        hashtagRepo.save(hashtag1);
        hashtagRepo.save(hashtag2);
        hashtagRepo.save(hashtag3);

        List<Hashtag> hashtagList1 = new ArrayList<>();
        hashtagList1.add(hashtag2);

        Post post1 = new Post("Honda CRX Si",
                "The Honda CRX Si is a brilliant little car- endowed with not much power and a scant curb weight to match. " +
                        "In 1988, the second-generation CRX Si was introduced in North America. These later cars are the stuff of legend. " +
                        "They were cheap, light, precise, and about as mechanically complex as a screwdriver. " +
                        "They also came at a small sticker price, further adding to their desirability.",
                author1,
                LocalDateTime.now(),
                "../../images/CRX1.jpg",
                genre2,
                hashtagList1);

        List<Hashtag> hashtagList2 = new ArrayList<>();
        hashtagList2.add(hashtag1);
        hashtagList2.add(hashtag3);

        Post post2 = new Post("Tesla Model S",
                "Tesla effectively created the luxury electric segment with the introduction of the first Model S back in 2012. " +
                        "Eight years later, larger, more established automakers are still trying to catch up. " +
                        "It's a car that changed the game and continues to serve as an industry benchmark. " +
                        "Today, with dual-motor AWD, autopilot, and ability to increase range past the 400-mile mark, the car still outperforms most of the other EV offerings on the market.",
                author2,
                LocalDateTime.now(),
                "../../images/teslaS.jpg",
                genre1,
                hashtagList2);

        Post post3 = new Post("Mercedes Benz 250SL",
                "This 1967 Mercedes Hardtop Convertible is extremely rare. Most of these were made with a soft top and no back seat. " +
                        "With only a few hundred 2x2 models made, it is very collectible and will fetch serious money. ",
                author2,
                LocalDateTime.now(),
                "../../images/mercedes.jpg",
                genre3,
                hashtagList1);

        List<Hashtag> hashtagList3 = new ArrayList<>();
        hashtagList3.add(hashtag3);




        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);


    }
}
