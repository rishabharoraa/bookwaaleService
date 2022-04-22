package com.bookwaale.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AuthorResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String description;

    private List<BookPreviewResponseDTO> books;
}
