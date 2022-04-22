package com.bookwaale.service.config;

import com.bookwaale.service.enums.Language;
import com.bookwaale.service.model.Author;
import com.bookwaale.service.service.AuthorService;
import com.bookwaale.service.model.Book;
import com.bookwaale.service.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Set;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            AuthorService authorService,
            BookService bookService
    ) {
        return args -> {

            Author ken = new Author("Ken Follett", "");
            authorService.createAuthor(ken);

            Author kafka = new Author("Franz Kafka", "");
            authorService.createAuthor(kafka);

            Book pillarsOfTheEarth = new Book(
                    "Pillars of the Earth",
                    authorService.getAuthor(1L),
                    1200L,
                    new Date(),
                    Set.of(Language.ENGLISH)
            );
            bookService.createBook(pillarsOfTheEarth);

            Book worldWithoutEnd = new Book(
                    "World Without End",
                    authorService.getAuthor(1L),
                    1000L,
                    new Date(),
                    Set.of(Language.ENGLISH)
            );
            bookService.createBook(worldWithoutEnd);

            Book sw = new Book(
                    "Selected Works",
                    authorService.getAuthor(2L),
                    250L,
                    new Date(),
                    Set.of(Language.ENGLISH)
            );
            bookService.createBook(sw);
        };
    }
}
