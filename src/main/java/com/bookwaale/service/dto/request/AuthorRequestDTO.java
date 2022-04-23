package com.bookwaale.service.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AuthorRequestDTO {
    private String authorName;
    private String description;
}
