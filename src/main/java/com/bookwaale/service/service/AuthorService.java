package com.bookwaale.service.service;

import com.bookwaale.service.dto.request.AuthorRequestDTO;
import com.bookwaale.service.dto.response.AuthorResponseDTO;
import com.bookwaale.service.dto.response.BookPreviewResponseDTO;
import com.bookwaale.service.model.Author;
import com.bookwaale.service.repository.AuthorRepository;
import com.bookwaale.service.repository.BookRepository;
import com.bookwaale.service.util.converter.AuthorEntityConverter;
import com.bookwaale.service.util.converter.BookEntityConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final AuthorEntityConverter authorEntityConverter;
    private final BookEntityConverter bookEntityConverter;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        Author savedAuthor = authorRepository
                .save(authorEntityConverter.toAuthor(authorRequestDTO));

        return authorEntityConverter.toAuthorResponseDTO(savedAuthor);
    }

    public Author getAuthor(Long authorId) throws Exception {
        return authorRepository
                .findById(authorId)
                .orElseThrow(() -> new Exception("Author not found!"));
    }

    public AuthorResponseDTO getAuthorResponseDTO(Long authorId) throws Exception {
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() -> new Exception("Author not found!"));

        List<BookPreviewResponseDTO> booksByAuthor = bookRepository
                .findAllByAuthorId(authorId)
                .stream()
                .map(bookEntityConverter::toBookPreviewResponseDTO)
                .collect(Collectors.toList());

        return new AuthorResponseDTO(
                authorId,
                author.getName(),
                author.getDescription(),
                booksByAuthor
        );
    }
}
