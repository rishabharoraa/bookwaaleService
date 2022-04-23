package com.bookwaale.service.controller;

import com.bookwaale.service.dto.request.AuthorRequestDTO;
import com.bookwaale.service.dto.response.AuthorResponseDTO;
import com.bookwaale.service.service.AuthorService;
import com.bookwaale.service.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public AuthorResponseDTO getAuthorResponseDTO(@PathVariable Long authorId) throws Exception {
        return authorService.getAuthorResponseDTO(authorId);
    }

    @PostMapping
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        return authorService.createAuthor(authorRequestDTO);
    }
}
