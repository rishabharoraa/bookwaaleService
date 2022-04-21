package com.bookwaale.service.service;

import com.bookwaale.service.dto.request.BookRequestDTO;
import com.bookwaale.service.enums.Language;
import com.bookwaale.service.model.Author;
import com.bookwaale.service.model.Book;
import com.bookwaale.service.repository.AuthorRepository;
import com.bookwaale.service.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) throws Exception {
        bookRepository.save(book);
    }

    public void createBook(BookRequestDTO bookRequestDTO) throws Exception {

        Set<Language> languagesEnumSet = bookRequestDTO.getLanguages().stream().map(
                lang -> {
                    return Language.valueOf(lang.toUpperCase());
                }
        ).collect(Collectors.toSet());

        if (bookRequestDTO.getPublicationDate() == null) {
            bookRequestDTO.setPublicationDate(new Date());
        }

        if (bookRequestDTO.getPages() == null) {
            bookRequestDTO.setPages(-1L);
        }

        Book book;

        if (bookRequestDTO.getAuthorId() != null) {
            Author author = authorRepository
                    .findById(bookRequestDTO.getAuthorId())
                    .orElseThrow(
                            () -> new Exception("Author not found")
                    );

            book = new Book(
                    bookRequestDTO.getTitle(),
                    author,
                    bookRequestDTO.getPages(),
                    bookRequestDTO.getPublicationDate(),
                    languagesEnumSet
            );
        } else {
            book = new Book(
                    bookRequestDTO.getTitle(),
                    bookRequestDTO.getPages(),
                    bookRequestDTO.getPublicationDate(),
                    languagesEnumSet
            );
        }

        bookRepository.save(book);
    }
}
