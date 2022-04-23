package com.bookwaale.service.service;

import com.bookwaale.service.dto.request.BookRequestDTO;
import com.bookwaale.service.enums.Language;
import com.bookwaale.service.model.Author;
import com.bookwaale.service.model.Book;
import com.bookwaale.service.repository.AuthorRepository;
import com.bookwaale.service.repository.BookRepository;
import com.bookwaale.service.util.converter.BookEntityConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final BookEntityConverter bookEntityConverter;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) throws Exception {
        bookRepository.save(book);
    }

    public void createBook(BookRequestDTO bookRequestDTO) throws Exception {

        Book book;

        if (bookRequestDTO.getAuthorId() != null) {
            Author author = authorRepository
                    .findById(bookRequestDTO.getAuthorId())
                    .orElseThrow(() -> new Exception("Author not found"));

            book = bookEntityConverter
                    .toBook(bookRequestDTO, author);

        } else {

            book = bookEntityConverter
                    .toBook(bookRequestDTO, null);
        }

        bookRepository.save(book);
    }

    public Book getBook(Long bookId) throws Exception {
        return bookRepository
                .findById(bookId)
                .orElseThrow(() -> new Exception("Book not found"));
    }

    public void deleteBook(Long bookId) throws Exception {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new Exception("Book not found");
        }
        bookRepository.deleteById(bookId);
    }

    public void updateBook(Long bookId, BookRequestDTO bookRequestDTO) throws Exception {
        boolean exists = bookRepository.existsById(bookId);

        if(!exists) {
            throw new Exception("book not found");
        }

        Book newBook;

        if(bookRequestDTO.getAuthorId() != null) {
            Author author = authorRepository
                    .findById(bookRequestDTO.getAuthorId())
                    .orElseThrow(() -> new Exception("Author not found"));
            newBook = bookEntityConverter
                    .toBook(bookRequestDTO, author);
        } else {
            newBook = bookEntityConverter
                    .toBook(bookRequestDTO, null);
        }

        newBook.setId(bookId);

        bookRepository.save(newBook);
    }
}
