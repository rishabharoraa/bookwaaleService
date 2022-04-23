package com.bookwaale.service.util.converter;

import com.bookwaale.service.dto.request.AuthorRequestDTO;
import com.bookwaale.service.dto.response.AuthorResponseDTO;
import com.bookwaale.service.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AuthorEntityConverter {
    public Author toAuthor(AuthorRequestDTO authorRequestDTO) {
        return new Author(
                authorRequestDTO.getAuthorName(),
                authorRequestDTO.getDescription()
        );
    }

    public AuthorResponseDTO toAuthorResponseDTO(Author author) {
        return new AuthorResponseDTO(
                author.getId(), author.getName(), author.getDescription(), List.of()
        );
    }
}
