package org.wcci.blog.service;

import org.springframework.stereotype.Service;
import org.wcci.blog.ResourceNotFoundException;
import org.wcci.blog.model.Author;
import org.wcci.blog.model.Genre;
import org.wcci.blog.model.Post;
import org.wcci.blog.repository.GenreRepository;
import org.wcci.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    GenreRepository genreRepo;
    public GenresService(GenreRepository genreRepo) {
        this.genreRepo = genreRepo;
    }


    public Iterable<Genre> getAllGenres() {
        return genreRepo.findAll();
    }

    public Genre getSingleGenre (Long id){
        Optional<Genre> genreOptional = genreRepo.findById(id);
        Genre foundGenre;
        if(genreOptional.isEmpty()){
            throw new ResourceNotFoundException("Genre not found.");
        }else{
            foundGenre= genreOptional.get();
        }
        return foundGenre;
    }

//    public void save(Genre genreToSave) {
//        genreRepo.save(genreToSave);
//    }

}
