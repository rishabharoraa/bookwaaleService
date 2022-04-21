package com.bookwaale.service.controller;

import com.bookwaale.service.dto.request.BookRequestDTO;
import com.bookwaale.service.service.BookService;
import com.bookwaale.service.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void createBook(
            @RequestBody @Valid BookRequestDTO bookRequestDTO
            ) throws Exception {
        bookService.createBook(bookRequestDTO);
    }
}
