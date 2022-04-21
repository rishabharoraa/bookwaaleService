package com.bookwaale.service.service;

import com.bookwaale.service.repository.AuthorRepository;
import com.bookwaale.service.model.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthor(Long authorID) throws Exception {
        return authorRepository
                .findById(authorID)
                .orElseThrow(() -> new Exception("Author not found!"));
    }
}
