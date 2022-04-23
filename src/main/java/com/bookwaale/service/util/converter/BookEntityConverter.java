package com.bookwaale.service.util.converter;

import com.bookwaale.service.dto.request.BookRequestDTO;
import com.bookwaale.service.dto.response.BookPreviewResponseDTO;
import com.bookwaale.service.enums.Language;
import com.bookwaale.service.model.Author;
import com.bookwaale.service.model.Book;
import com.bookwaale.service.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookEntityConverter {

    private final AuthorRepository authorRepository;

    public BookPreviewResponseDTO toBookPreviewResponseDTO(@NotNull Book book) {
        return new BookPreviewResponseDTO(
                book.getId(), book.getTitle()
        );
    }

    public Book toBook(@NotNull BookRequestDTO bookRequestDTO, Author author) {

        if (bookRequestDTO.getPublicationDate() == null) {
            bookRequestDTO.setPublicationDate(new Date());
        }

        if (bookRequestDTO.getPages() == null) {
            bookRequestDTO.setPages(-1L);
        }

        if (author != null) {
            return new Book(
                    bookRequestDTO.getTitle(),
                    author,
                    bookRequestDTO.getPages(),
                    bookRequestDTO.getPublicationDate(),
                    toLanguageEnumSet(bookRequestDTO.getLanguages())
            );
        } else {
            return new Book(
                    bookRequestDTO.getTitle(),
                    bookRequestDTO.getPages(),
                    bookRequestDTO.getPublicationDate(),
                    toLanguageEnumSet(bookRequestDTO.getLanguages())
            );
        }
    }

    public Set<Language> toLanguageEnumSet(@NotNull Set<String> languageList) {
        return languageList
                .stream()
                .map(
                        lang -> {
                            return Language.valueOf(lang.toUpperCase());
                        })
                .collect(Collectors.toSet());
    }
}
